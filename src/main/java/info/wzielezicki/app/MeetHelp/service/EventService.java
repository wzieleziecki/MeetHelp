package info.wzielezicki.app.MeetHelp.service;

/**
 * Created by wzielezi on 2017-05-25.
 */

import info.wzielezicki.app.MeetHelp.model.Event;
import info.wzielezicki.app.MeetHelp.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static java.util.stream.Collectors.toList;
import java.util.List;

@Service
public class EventService implements ServiceInterface<Event>{

    private EventRepository eventRepository;

    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public List<Event> getObj() {
        List <Event> eventList = eventRepository.findAll();
        return convertToDTOs(eventList);
    }

    private List<Event> convertToDTOs (List<Event> models){
        return models
                .stream()
                .map(this::convertToDTO)
                .collect(toList());

        // TODO: 2017-05-25 nie rozumiem zapisu wyrażeń lambda, nie wiem jak przekłada się to na inny zapis
    }

    private Event convertToDTO (Event model){
        Event dto = new Event();
        dto.setId(model.getId());
        dto.setEventDateConfirmTo(model.getEventDateConfirmTo());
        dto.setEventDateFrom(model.getEventDateFrom());
        dto.setEventDateTo(model.getEventDateTo());
        dto.setEventTitle(model.getEventTitle());
        dto.setLocation(model.getLocation());
        dto.setMinEventTime(model.getMinEventTime());
        dto.setMinEventPartcipants(model.getMinEventPartcipants());

        return dto;
    }

    @Override
    public Event create(Event obj) {
        return eventRepository.save(obj);
    }

    @Override
    public Event findById(String id) {
        return null;
    }

    @Override
    public Event update(Event obj) {
        return null;
    }
}
