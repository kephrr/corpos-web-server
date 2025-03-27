package corpos.dakar.web_server.data.repositories;

import corpos.dakar.web_server.data.entites.EventTicket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventTicketRepository extends JpaRepository<EventTicket, Long> {
}
