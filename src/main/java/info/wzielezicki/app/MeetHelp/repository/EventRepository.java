package info.wzielezicki.app.MeetHelp.repository;

import info.wzielezicki.app.MeetHelp.model.Event;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.stream.Stream;

/**
 * Created by wzielezi on 2017-05-24.
 */
public interface EventRepository extends MongoRepository <Event, String> {

    Stream<Event> findByLocation(String location);

    List<Event> findByMinEventPartcipants(String minEventParticipant);

    List<Event> findById(String eventId);

}
