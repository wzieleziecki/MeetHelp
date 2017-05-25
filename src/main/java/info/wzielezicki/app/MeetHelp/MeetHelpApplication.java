package info.wzielezicki.app.MeetHelp;

import info.wzielezicki.app.MeetHelp.model.Event;
import info.wzielezicki.app.MeetHelp.model.Participant;
import info.wzielezicki.app.MeetHelp.service.EventService;
import info.wzielezicki.app.MeetHelp.service.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@ComponentScan
public class MeetHelpApplication implements CommandLineRunner{

	@Autowired
	public EventService eventService;

	@Autowired
	public ParticipantService participantService;

	public static void main(String[] args) {
		SpringApplication.run(MeetHelpApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {

		Event eventObj = new Event("Wyjazd na rower Turbacz", "27.05.2017 10:00:00", "27.05.2017 22:00:00", "2", "26.05.2017 10:00:00", "Lindego 13", "06:00:00" );
		eventService.create(eventObj);

		Participant participantObj = new Participant("8423947", "Wojciech", "Zieleziecki", "wojciech.zieleziecki@gmail.com", "1", "27.05.2017 11:00", "27.05.2017 19:00");
		participantService.create(participantObj);

	}
}
