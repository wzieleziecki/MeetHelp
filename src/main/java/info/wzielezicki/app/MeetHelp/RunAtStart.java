package info.wzielezicki.app.MeetHelp;

import info.wzielezicki.app.MeetHelp.model.Event;
import info.wzielezicki.app.MeetHelp.model.Participant;
import info.wzielezicki.app.MeetHelp.repository.EventRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * Created by wzielezi on 2017-05-27.
 */
@Component
public class RunAtStart {

    private final EventRepository eventRepository;
    private final Logger logger = Logger.getLogger(RunAtStart.class);

    @Autowired
    public RunAtStart(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @PostConstruct
    public void runAtStart(){
        Event eventObj = new Event("Wyjazd na rower Turbacz", "27.05.2017 10:00:00", "27.05.2017 22:00:00", "2", "26.05.2017 10:00:00", "Lindego 13", "06:00:00" );
        eventRepository.save(eventObj);

        logger.info("#################### Wyszukiwanie po minimalnej ilości uczestników ###########################");
       // printAll(eventRepository.findByMinEventPartcipants("2"));

//        Stream<Event> eventStream = eventRepository.findByLocation("Lindego 13");
//        List<String> EventCollection = eventStream.map(Event::getLocation).collect(Collectors.toList());
//
//        logger.info(EventCollection);

        Stream<Event> eventStream = eventRepository.findByMinEventPartcipants("Lindego 13");
        List<String> eventCollection = eventStream.map(Event::getMinEventPartcipants).collect(Collectors.toList());

        logger.info(eventCollection);
        String minParticipant = eventCollection.get(0);
        if(minParticipant == "1"){
            System.out.println(minParticipant + " nie równa się 1");
        } else System.out.println(minParticipant + " to działa");
    }
    private void printAll(List<Event> allEvent){allEvent.forEach(logger::info);}

}
