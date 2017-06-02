package info.wzielezicki.app.MeetHelp;

import info.wzielezicki.app.MeetHelp.model.Event;
import info.wzielezicki.app.MeetHelp.model.Participant;
import info.wzielezicki.app.MeetHelp.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@SpringBootApplication
@Configuration
@ComponentScan
public class MeetHelpApplication implements CommandLineRunner {

	private final EventRepository eventRepository;

	@Autowired
	public MeetHelpApplication(EventRepository eventRepository) {
		this.eventRepository = eventRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(MeetHelpApplication.class, args);

	}

	@Override
	public void run(String... strings) throws Exception {
		// TODO: 2017-06-01 jeżeli data dostępności użytkownika znajduje się pomiędzy wartościamui to idż dale (aplikacja musi mieć zaszyte to w polu w którym user będzie wprowadzał dane)
		// TODO: 2017-06-01 przerobić to na klase rest tak żeby wynik można było uzyskac JASOnem
		// TODO: 2017-06-01 email ma zostać wysłany dnia eventDataConfirmationTo
//		List<Event> eventList = eventRepository.findAll();
//		for(Event e: eventList){
//
//			System.out.println("Przerabiam dokument o ID: " + e.getId());
//
//			List<Long> attendDateFromList = new ArrayList<>();
//			List<Long> attendDateToList = new ArrayList<>();
//			int minimumParticipant = e.getParticipantList().size();
//			System.out.println(e.getParticipantList().size());
//
//			for(Participant p: e.getParticipantList()){
//				attendDateFromList.add(p.getAttendDataFrom().getTime());
//				attendDateToList.add(p.getAttendDataTo().getTime());
//
//			}
//			long maxDateFrom = Collections.max(attendDateFromList);
//			long minDateTo = Collections.min(attendDateToList);
//
//			System.out.println("Minimalna data: " + minDateTo);
//			System.out.println("Max data: " + maxDateFrom);
//			System.out.println((minDateTo - maxDateFrom )/ (60 * 60 * 1000) % 24);
//
//			// TODO: 2017-06-01 informacje na temat problemów ze spotkaniem nie spełniony czas / minimalna ilość uczestnuików itp musi być logowany
//			if ((((minDateTo - maxDateFrom) / (60 * 60 * 1000) % 24 )>= e.getMinEventTime()) && minimumParticipant >= e.getMinEventPartcipants() ){
//					System.out.println("Spotkanie odbędzie się w godzinach od: "+  maxDateFrom +" do: "+minDateTo );
//				}else System.out.println("Spotkanie nie odbędzie się, minimalny czas spotkania "+ e.getMinEventTime() + " nie został spełniony"  );
//		}

	}
}

