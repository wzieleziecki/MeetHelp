package info.wzielezicki.app.MeetHelp;

import info.wzielezicki.app.MeetHelp.model.Event;
import info.wzielezicki.app.MeetHelp.model.Participant;
import info.wzielezicki.app.MeetHelp.repository.EventRepository;
import info.wzielezicki.app.MeetHelp.repository.ParticipantRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;


/**
 * Created by wzielezi on 2017-05-27.
 */
@Component
@EnableScheduling
public class RunAtStart {

    //private final MongoOperations mongoOperations;
    private final EventRepository eventRepository;
    private final ParticipantRepository participantRepository;
    private final MongoOperations mongoOperations;
    private final Logger logger = Logger.getLogger(RunAtStart.class);
    private final MongoTemplate mongoTemplate;

    @Autowired
    public RunAtStart(EventRepository eventRepository, ParticipantRepository participantRepository, MongoOperations mongoOperations, MongoTemplate mongoTemplate) {
        this.eventRepository = eventRepository;
        this.participantRepository = participantRepository;
        this.mongoOperations = mongoOperations;
        this.mongoTemplate = mongoTemplate;
    }

    @PostConstruct
    @Scheduled(cron = "0,30 * * * * *")
    public void runAtStart(){
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<Event> eventList = eventRepository.findAll();
        for(Event e: eventList){

            System.out.println("Przerabiam dokument o ID: " + e.getId());

            List<Long> attendDateFromList = new ArrayList<>();
            List<Long> attendDateToList = new ArrayList<>();
            int minimumParticipant = e.getParticipantList().size();
            System.out.println("ilość uczestników eventu" +e.getId()+ " " + e.getParticipantList().size());

            for(Participant p: e.getParticipantList()){
                try {
                    attendDateFromList.add(format.parse(p.getAttendDataFrom()).getTime());
                } catch (ParseException e1) {
                    e1.printStackTrace();
                }
                try {
                    attendDateToList.add(format.parse(p.getAttendDataTo()).getTime());
                } catch (ParseException e1) {
                    e1.printStackTrace();
                }

            }
            long maxDateFrom = Collections.max(attendDateFromList);
            long minDateTo = Collections.min(attendDateToList);

            System.out.println("Minimalna data: " + minDateTo);
            System.out.println("Max data: " + maxDateFrom);
            System.out.println((minDateTo - maxDateFrom )/ (60 * 60 * 1000) % 24);

            // TODO: 2017-06-01 informacje na temat problemów ze spotkaniem nie spełniony czas / minimalna ilość uczestnuików itp musi być logowany
            if ((((minDateTo - maxDateFrom) / (60 * 60 * 1000) % 24 )>= e.getMinEventTimeInHours()) && minimumParticipant >= e.getMinEventPartcipants() ){

                Query query = new Query(Criteria.where("id").is(e.getId()));
                Update update = new Update();
                update.set("optimalMeetingTimeFrom", format.format(new Date(maxDateFrom)));
                update.set("optimalMeetingTimeto", format.format(new Date(minDateTo)));
                mongoTemplate.updateFirst(query, update, Event.class);

                System.out.println("Spotkanie odbędzie się w godzinach od: "+  maxDateFrom +" do: "+minDateTo );
            }else System.out.println("Spotkanie nie odbędzie się, minimalny czas spotkania "+ e.getMinEventTimeInHours() + " nie został spełniony"  );
        }
    }
//    private void printAll(List<Event> allEvent){allEvent.forEach(logger::info);}
}
