package corpos.dakar.web_server.data.fixtures;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import corpos.dakar.web_server.data.entites.Event;
import corpos.dakar.web_server.data.enums.EventState;
import corpos.dakar.web_server.data.repositories.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(0)
@Component
@RequiredArgsConstructor
public class EventFixtures implements CommandLineRunner {
    private final EventRepository eventRepository;
    @Override
    public void run(String... args) throws Exception {
        String[] events = {"Match de GALA","Match d'ouverture féminin","Tournoi EFOULAME","Camp d'entrainement"};
        String[] dates = {"30-03-2025", "10-04-2025","24-04-2025","02-05-2025"};
        Double[] durees = {4.0, 4.0, 10.0, 8.5};

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        for (int i = 0; i < events.length; i++) {
            try {
                Date date = formatter.parse(dates[i]);
                System.out.println("Date convertie: " + date);
                eventRepository.save(Event.builder()
                                .libelle(events[i])
                                .date(date)
                                .state(EventState.values()[(i+1)%5])
                                .duration(durees[i])
                        .build());
            } catch (ParseException e) {
                System.out.println("Erreur de parsing: " + e.getMessage());
            }
        }

    }
}










