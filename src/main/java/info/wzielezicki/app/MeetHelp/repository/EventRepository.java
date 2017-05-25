package info.wzielezicki.app.MeetHelp.repository;

import info.wzielezicki.app.MeetHelp.model.Event;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by wzielezi on 2017-05-24.
 */
public interface EventRepository extends MongoRepository <Event, String> {
}
