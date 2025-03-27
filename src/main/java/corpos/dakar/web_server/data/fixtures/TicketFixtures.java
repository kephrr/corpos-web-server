package corpos.dakar.web_server.data.fixtures;

import corpos.dakar.web_server.data.entites.Event;
import corpos.dakar.web_server.data.entites.Ticket;
import corpos.dakar.web_server.data.enums.TicketState;
import corpos.dakar.web_server.repositories.EventRepository;
import corpos.dakar.web_server.repositories.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;

@Order(1)
//@Component
@RequiredArgsConstructor
public class TicketFixtures implements CommandLineRunner {
    private final TicketRepository repository;
    private final EventRepository eventRepository;
    @Override
    public void run(String... args) throws Exception {
        String[] names = {"Kephren NZE", "Déborah AYINGONE", "Sunny Ginger"};
        String[] emails = {"kephnze@gmail.com", "deborahamys@gmail.com", "sunny-ginger@catmail.miaouw"};
        String[] telephones = {"784776687","782954817","000000011"};

        for(int i=0;i<names.length;i++) {
            Event e = eventRepository.findById((long) i%4).orElse(null);
            repository.save(Ticket.builder()
                            .name(names[i])
                            .email(emails[i])
                            .telephone(telephones[i])
                            .state(TicketState.values()[(i+1)%3])
                            .event(e)
                    .build());
        }
    }
}



