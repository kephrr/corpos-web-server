package corpos.dakar.web_server.data.fixtures;

import corpos.dakar.web_server.Config;
import corpos.dakar.web_server.data.entites.Event;
import corpos.dakar.web_server.data.entites.Ticket;
import corpos.dakar.web_server.data.enums.TicketState;
import corpos.dakar.web_server.repositories.EventRepository;
import corpos.dakar.web_server.repositories.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Order(1)
//@Component
@RequiredArgsConstructor
public class TicketFixtures implements CommandLineRunner {
    private final TicketRepository repository;
    private final EventRepository eventRepository;
    @Override
    public void run(String... args) throws Exception {
        String[] names = {"Kephren NZE", "Déborah AYINGONE", "Sunny Ginger", "Yann", "Cade Cunningham", "Tyrese Haliburton"};
        String[] emails = {"kephnze@gmail.com", "deborahamys@gmail.com","sunny-ginger@catmail.miaouw", "yannmeds@gmail.com","cade2cunningham@nba.com","tyhali@nba.com"};
        String[] telephones = {"784776687","777954817","000000011", "784700687","762955817","760200011"};
        String[] dates = {"30-03-2025", "13-02-2025","27-03-2025","03-03-2025","27-02-2025","03-03-2025"};
        SimpleDateFormat formatter = new SimpleDateFormat(Config.dateFormatPattern);

        for(int i=0;i<names.length;i++) {
            Date date = formatter.parse(dates[i]);
            Event e = eventRepository.findById((long) i%4).orElse(null);
            repository.save(Ticket.builder()
                            .name(names[i])
                            .email(emails[i])
                            .telephone(telephones[i])
                            .state(TicketState.values()[(i+1)%3])
                            .orderingDate(date)
                            .event(e)
                    .build());
        }
    }
}



