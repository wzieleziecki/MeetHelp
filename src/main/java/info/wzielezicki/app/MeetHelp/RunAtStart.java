package info.wzielezicki.app.MeetHelp;

import info.wzielezicki.app.MeetHelp.repository.EventRepository;
import info.wzielezicki.app.MeetHelp.repository.ParticipantRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


/**
 * Created by wzielezi on 2017-05-27.
 */
@Component
public class RunAtStart {

    //private final MongoOperations mongoOperations;
    private final EventRepository eventRepository;
    private final ParticipantRepository participantRepository;
    private final MongoOperations mongoOperations;
    private final Logger logger = Logger.getLogger(RunAtStart.class);
    public RunAtStart(EventRepository eventRepository, ParticipantRepository participantRepository, MongoOperations mongoOperations) {
        this.eventRepository = eventRepository;
        this.participantRepository = participantRepository;
        this.mongoOperations = mongoOperations;
    }

    @Autowired


    @PostConstruct
    public void runAtStart(){

//
//        Participant participant = new Participant();
//        Participant participant2 = new Participant();
//        Participant participant3 = new Participant();
//        Event event = new Event();
//
//        event.setEventTitle("Wyjazd na rower Turbacz");
//        event.setEventDateFrom(new Date());
//        event.setEventDateTo("27.05.2017 22:00:00");
//        event.setMinEventPartcipants(2);
//        event.setEventDateConfirmTo("26.05.2017 10:00:00");
//        event.setLocation("Lindego 13a");
//        event.setMinEventTime("06:00:00");
//
//        List<Participant> participantList = new ArrayList<>();
//        participantList.add(participant);
//        List<Participant> participantList2 = new ArrayList<>();
//        participantList.add(participant2);
//        List<Participant> participantList3 = new ArrayList<>();
//        participantList.add(participant3);
//        event.setParticipantList(participantList);
//        event.setParticipantList(participantList2);
//        event.setParticipantList(participantList3);
//
//
//        participant.setSurname("Zieleziecki");
//        participant.setName("Wojciech");
//        participant.setIdEvent("");
//        participant.setEmail("wojciech.zieleziecki@gmail.com");
//        participant.setAttend(1);
//        participant.setAttendDataFrom(new Date());
//        participant.setAttendDataTo(new Date());
//
//        participant2.setSurname("Zieleziecki");
//        participant2.setName("Iza");
//        participant2.setIdEvent("");
//        participant2.setEmail("wojciech.zieleziecki@gmail.com");
//        participant2.setAttend(1);
//        participant2.setAttendDataFrom(new Date());
//        participant2.setAttendDataTo(new Date());
//
//        participant3.setSurname("Zieleziecki");
//        participant3.setName("Heniek");
//        participant3.setIdEvent("");
//        participant3.setEmail("wojciech.zieleziecki@gmail.com");
//        participant3.setAttend(1);
//        participant3.setAttendDataFrom(new Date());
//        participant3.setAttendDataTo(new Date());
//
//
//        eventRepository.save(event);
//        participantRepository.save(participant);
//
//
//        eventRepository.save(event);
//        participantRepository.save(participant);

    }
//    private void printAll(List<Event> allEvent){allEvent.forEach(logger::info);}
}
