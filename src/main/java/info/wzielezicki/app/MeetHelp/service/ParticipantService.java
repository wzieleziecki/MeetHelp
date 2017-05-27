package info.wzielezicki.app.MeetHelp.service;

import info.wzielezicki.app.MeetHelp.model.Participant;
import info.wzielezicki.app.MeetHelp.repository.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static java.util.stream.Collectors.toList;

import java.util.List;

/**
 * Created by wzielezi on 2017-05-25.
 */
@Service
public class ParticipantService implements ServiceInterface<Participant>, CustomInterfaceParticipant {

    private ParticipantRepository participantRepository;

    @Autowired
    public ParticipantService(ParticipantRepository participantRepository) {
        this.participantRepository = participantRepository;
    }

    @Override
    public List<Participant> getObj() {
        List<Participant> participantList = participantRepository.findAll();
        return convertToDTOs(participantList);
    }

    private List<Participant> convertToDTOs( List<Participant> models){
        return models
                .stream()
                .map(this::convertToDTO)
                .collect(toList());
    }

    // TODO: 2017-05-25 convertToDTO występuje w obu klasach może wato przerobić go na klasę?

    private Participant convertToDTO (Participant model){

        Participant dto = new Participant();
        dto.setAttend(model.getAttend());
        dto.setAttendDataFrom(model.getAttendDataFrom());
        dto.setAttendDataTo(model.getAttendDataTo());
        dto.setEmail(model.getEmail());
        dto.setIdEvent(model.getIdEvent());
        dto.setName(model.getName());
        dto.setSurname(model.getSurname());

        return dto;
    }

    @Override
    public Participant create(Participant obj) {
        return participantRepository.save(obj);
    }

    @Override
    public Participant findById(String id) {
        return null;
    }

    @Override
    public Participant update(Participant obj) {
        return null;
    }


    @Override
    public List<Participant> findByIdEvent(String id) {
        return null;
    }
}
