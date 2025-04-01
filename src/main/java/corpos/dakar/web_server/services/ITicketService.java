package corpos.dakar.web_server.services;

import corpos.dakar.web_server.data.entites.Event;
import corpos.dakar.web_server.data.entites.Ticket;
import corpos.dakar.web_server.data.enums.TicketState;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ITicketService extends IServiceCore<Ticket, Long> {
    int checkNewTickets();
    Page<Ticket> findAll(Pageable pageable, TicketState state, Event event);
}
