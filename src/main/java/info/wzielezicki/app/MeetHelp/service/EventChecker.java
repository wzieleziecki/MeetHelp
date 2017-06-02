package info.wzielezicki.app.MeetHelp.service;

import info.wzielezicki.app.MeetHelp.model.Event;
import info.wzielezicki.app.MeetHelp.model.Participant;
import info.wzielezicki.app.MeetHelp.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by wzielezi on 2017-06-01.
 */
public class EventChecker {

//    private final EventRepository eventRepository;
//
//    @Autowired
//    public EventChecker(EventRepository eventRepository) {
//        this.eventRepository = eventRepository;
//    }
//
//        public long findOptimalEventTimeFor (List<Event> eventList){
//    //List<Event> eventList = eventRepository.findAll(); - to muszę dostrać w klasie w której będę implementował tą klasę
//		for(Event e: eventList){
//
//     //   System.out.println("Przerabiam dokument o ID: " + e.getId());
//
//        List<Long> attendDateFromList = new ArrayList<>();
//        List<Long> attendDateToList = new ArrayList<>();
////        int minimumParticipant = e.getParticipantList().size(); - to powinienem przerabiać w innej metodzie
//       // System.out.println(e.getParticipantList().size());
//        for(Participant p: e.getParticipantList()){
//            attendDateFromList.add(p.getAttendDataFrom().getTime());
//            attendDateToList.add(p.getAttendDataTo().getTime());
//        }
//        long maxDateFrom = Collections.max(attendDateFromList);
//        long minDateTo = Collections.min(attendDateToList);
//
//      //  System.out.println("Minimalna data: " + minDateTo);
//      //  System.out.println("Max data: " + maxDateFrom);
//        System.out.println((minDateTo - maxDateFrom )/ (60 * 60 * 1000) % 24);
//
//        // TODO: 2017-06-01 informacje na temat problemów ze spotkaniem nie spełniony czas / minimalna ilość uczestnuików itp musi być logowany
//        if ((((minDateTo - maxDateFrom) / (60 * 60 * 1000) % 24 )>= e.getMinEventTime()) && minimumParticipant >= e.getMinEventPartcipants() ){
//            System.out.println("Spotkanie odbędzie się w godzinach od: "+  maxDateFrom +" do: "+minDateTo );
//        }else System.out.println("Spotkanie nie odbędzie się, minimalny czas spotkania "+ e.getMinEventTime() + " nie został spełniony"  );
//    }
//        return 0;
//
//            /**
//             * 1. metoda wybierająca optymalny czas spotkania dla eventu
//             */
//
//    }
}
