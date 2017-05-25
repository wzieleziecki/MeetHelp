package info.wzielezicki.app.MeetHelp.service;

import info.wzielezicki.app.MeetHelp.model.Participant;

import java.util.List;

/**
 * Created by wzielezi on 2017-05-25.
 */
public interface CustomInterfaceParticipant {

    List<Participant> findByIdEvent(String id);
}
