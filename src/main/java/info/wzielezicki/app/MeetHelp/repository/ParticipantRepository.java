package info.wzielezicki.app.MeetHelp.repository;

import info.wzielezicki.app.MeetHelp.model.Participant;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by wzielezi on 2017-05-24.
 */
public interface ParticipantRepository extends MongoRepository <Participant, String>{

}
