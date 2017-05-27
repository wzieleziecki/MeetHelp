package info.wzielezicki.app.MeetHelp.rest;

import info.wzielezicki.app.MeetHelp.model.Event;
import info.wzielezicki.app.MeetHelp.model.Participant;
import info.wzielezicki.app.MeetHelp.service.EventService;
import info.wzielezicki.app.MeetHelp.service.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    public AppRESTController(EventService eventService, ParticipantService participantService) {
        this.eventService = eventService;
        this.participantService = participantService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getEvent")
    public @ResponseBody List<Event> findAll(){
        return eventService.getObj();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/sevaEvent")
    public @ResponseBody Event createEvent(@RequestBody Event eventEntity){
        return eventService.create(eventEntity);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/saveParticipant")
    public  @ResponseBody Participant createParticipant (@RequestBody Participant participantEntity){
        return participantService.create(participantEntity);
    }

}
