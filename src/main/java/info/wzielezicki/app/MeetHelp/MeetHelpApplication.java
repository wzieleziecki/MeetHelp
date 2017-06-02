package info.wzielezicki.app.MeetHelp;

import info.wzielezicki.app.MeetHelp.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@Configuration
@ComponentScan
@EnableScheduling
public class MeetHelpApplication {

	private final EventRepository eventRepository;

	@Autowired
	public MeetHelpApplication(EventRepository eventRepository) {
		this.eventRepository = eventRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(MeetHelpApplication.class, args);
	}
}

