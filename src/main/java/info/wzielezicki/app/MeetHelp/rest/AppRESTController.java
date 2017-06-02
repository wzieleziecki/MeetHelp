package info.wzielezicki.app.MeetHelp.rest;

import info.wzielezicki.app.MeetHelp.model.Event;
import info.wzielezicki.app.MeetHelp.repository.EventRepository;
import info.wzielezicki.app.MeetHelp.service.EventService;
import info.wzielezicki.app.MeetHelp.service.ParticipantService;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    // TODO: 2017-06-02 przerobić na zmienne z zapytania https://www.youtube.com/watch?v=Hdd4nCncedg&index=11&list=PLU2dl_1LV_STR4IV60K_6wKBJpVkIHEiY
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

    //Zapis nowego eventu do bazy
    @RequestMapping(method = RequestMethod.POST, value = "/sevaEvent")
    public @ResponseBody Event createEvent(@RequestBody Event eventEntity){
        return eventRepository.save(eventEntity);
    }

}
