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

//    @Query("{'minEventPartcipants' : ?0}")
//    List<Event> findByMinEventPartcipants(String minParticipant);

    @Query("{'location' : ?0}")
    Stream<Event> findByLocation(String location);

    @Query("{'location' : ?0}")
    Stream<Event> findByMinEventPartcipants(String location);
}
