package info.wzielezicki.app.MeetHelp.rest;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.WriteResult;
import info.wzielezicki.app.MeetHelp.model.Event;
import info.wzielezicki.app.MeetHelp.model.Participant;
import info.wzielezicki.app.MeetHelp.repository.EventRepository;
import info.wzielezicki.app.MeetHelp.service.EventService;
import info.wzielezicki.app.MeetHelp.service.ParticipantService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by wzielezi on 2017-05-25.
 */

@RestController
@RequestMapping("/api/event")
public class AppRESTController {

    private final EventService eventService;
    private final ParticipantService participantService;
    private final EventRepository eventRepository;
    private final MongoTemplate mongoTemplate;
    private final MongoOperations mongoOperation;

    public AppRESTController(EventService eventService, ParticipantService participantService, EventRepository eventRepository, MongoTemplate mongoTemplate, MongoOperations mongoOperation) {
        this.eventService = eventService;
        this.participantService = participantService;
        this.eventRepository = eventRepository;
        this.mongoTemplate = mongoTemplate;
        this.mongoOperation = mongoOperation;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getEvent")
    public @ResponseBody List<Event> findAll(){
        // TODO: 2017-06-02 tylko aktywne

        return eventRepository.findAll();
    }


    //Aktualizacja eventu z adresu URL
    @GetMapping("/{eventId}/{email}/{from}/{to}")
    public void updateOptimalMeetingData(

            @PathVariable("eventId") String eventId,
            @PathVariable("email") String email,
            @PathVariable("from") String from,
            @PathVariable("to") String to
    )
    {
        Query query = new Query(Criteria.where("id").is(eventId).and("participantList.email").is(email));
        Update update = new Update();
                update.set("participantList.$.attendDataFrom", from);
                update.set("participantList.$.attendDataTo", to);
        mongoTemplate.updateFirst(query, update, Event.class);
    }


    @RequestMapping(method = RequestMethod.GET, value = "/participantAvailability")
    public @ResponseBody long participantAvailability(){

        Query query = new Query();
        query.with(new Sort(Sort.Direction.ASC, "eventDateFrom"));
        query.limit(1);
        Event event = mongoTemplate.findOne(query, Event.class);

        Query query1 = new Query();
        query.with(new Sort(Sort.Direction.DESC, "eventDateFrom"));
        query.limit(1);
        Event event1 = mongoTemplate.findOne(query1, Event.class);
        long availabilityOfParticipants = (event1.getEventDateFrom().getTime() - event.getEventDateFrom().getTime())/ (24 * 60 * 60 * 1000);
        return availabilityOfParticipants;
    }

    //Zapis nowego eventu do bazy
    @RequestMapping(method = RequestMethod.POST, value = "/sevaEvent")
    public @ResponseBody Event createEvent(@RequestBody Event eventEntity){
        return eventRepository.save(eventEntity);
    }

//    @RequestMapping(method = RequestMethod.POST, value = "/saveParticipant")
//    public  @ResponseBody Participant createParticipant (@RequestBody Participant participantEntity){
//        return participantService.create(participantEntity);
//    }
//
//    @RequestMapping(method = RequestMethod.GET, value = "/getEvent2")
//    public @ResponseBody List<Event> findAll2(){
//        return eventRepository.findByMinEventPartcipants("Lindego");
//    }
}
