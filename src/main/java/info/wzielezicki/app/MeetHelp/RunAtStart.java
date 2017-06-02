package info.wzielezicki.app.MeetHelp;

import info.wzielezicki.app.MeetHelp.model.Event;
import info.wzielezicki.app.MeetHelp.model.Participant;
import info.wzielezicki.app.MeetHelp.repository.EventRepository;
import info.wzielezicki.app.MeetHelp.repository.ParticipantRepository;
import info.wzielezicki.app.MeetHelp.service.NotificationService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.mail.MailException;
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
    private final NotificationService notificationService;

    public RunAtStart(EventRepository eventRepository, ParticipantRepository participantRepository, MongoOperations mongoOperations, MongoTemplate mongoTemplate, NotificationService notificationService) {
        this.eventRepository = eventRepository;
        this.participantRepository = participantRepository;
        this.mongoOperations = mongoOperations;
        this.mongoTemplate = mongoTemplate;
        this.notificationService = notificationService;
    }

    @Autowired


    @PostConstruct
    @Scheduled(cron = "0,30 * * * * *")
    public void runAtStart(){
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<Event> eventList = eventRepository.findAll();
        Update update = new Update();
        for(Event e: eventList){

            System.out.println("Przerabiam dokument o ID: " + e.getId());

            List<Long> attendDateFromList = new ArrayList<>();
            List<Long> attendDateToList = new ArrayList<>();
            List<String> participantMailAddressesList = new ArrayList<>();
            int minimumParticipant = e.getParticipantList().size();
            System.out.println("ilość uczestników eventu " +e.getId()+ " " + e.getParticipantList().size());

            for(Participant p: e.getParticipantList()){
                try {
                    attendDateFromList.add(format.parse(p.getAttendDataFrom()).getTime());
                } catch (ParseException e1) {
                    logger.info("Error parsowanie daty attendDataFrom" +e1.getMessage());
                }
                try {
                    attendDateToList.add(format.parse(p.getAttendDataTo()).getTime());
                } catch (ParseException e1) {
                    logger.info("Error parsowanie daty attendDataTo" +e1.getMessage());
                }
                participantMailAddressesList.add(p.getEmail());
                try {
                    String url = "http://localhost:8080/api/event/"+e.getId()+"/"+p.getEmail()+"/dostępność od yyyy-mm-dd gg:mm:ss/ dostępność do yyyy-mm-dd gg:mm:ss ";
                    notificationService.sendNotification(p.getEmail(), e.getEventTitle(), url);
                }catch ( MailException e1){
                    logger.info("Error wysyłanie maila "+ e1.getMessage() );
                }
                Query query = new Query(Criteria.where("id").is(e.getId()).and("status").is("A"));
                update.set("status","S");
                mongoTemplate.updateFirst(query, update, Event.class);

            }
            long maxDateFrom = Collections.max(attendDateFromList);
            long minDateTo = Collections.min(attendDateToList);

            logger.info("Minimalna data: " + minDateTo);
            logger.info("Max data: " + maxDateFrom);
            logger.info((minDateTo - maxDateFrom )/ (60 * 60 * 1000) % 24);

            // TODO: 2017-06-01 informacje na temat problemów ze spotkaniem nie spełniony czas / minimalna ilość uczestników itp musi być logowany
            // TODO: 2017-06-01 email ma zostać wysłany dnia eventDataConfirmationTo
            if ((((minDateTo - maxDateFrom) / (60 * 60 * 1000) % 24 )>= e.getMinEventTimeInHours()) && minimumParticipant >= e.getMinEventPartcipants() ){

                //zapisanie optymalnego czasu spotkania
                Query query = new Query(Criteria.where("id").is(e.getId()));
                update.set("optimalMeetingTimeFrom", format.format(new Date(maxDateFrom)));
                update.set("optimalMeetingTimeto", format.format(new Date(minDateTo)));
                mongoTemplate.updateFirst(query, update, Event.class);

                for ( String mail: participantMailAddressesList) {
                    try {
                        String message = "Spotkanie "+e.getEventTitle()+" odbędzie się w "+ e.getLocation()+ " "+ e.getOptimalMeetingTimeFrom() +" - "+ e.getOptimalMeetingTimeto();
                        notificationService.sendNotification(mail, e.getEventTitle(), message);
                    }catch ( MailException e1){
                        logger.info("Error wysyłanie maila "+ e1.getMessage() );
                    }
                    new Query(Criteria.where("id").is(e.getId()).and("status").is("A"));
                    update.set("status","D");
                    mongoTemplate.updateFirst(query, update, Event.class);
                }

                logger.info("Spotkanie odbędzie się w godzinach od: "+  maxDateFrom +" do: "+minDateTo );
                logger.info("Lista maili uczastników spotkania" +participantMailAddressesList);
            }else System.out.println("Spotkanie nie odbędzie się, minimalny czas spotkania "+ e.getMinEventTimeInHours() + " nie został spełniony"  );
        }
    }
}
