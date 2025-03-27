package corpos.dakar.web_server.data.repositories;

import corpos.dakar.web_server.data.entites.EventTicket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventTicketRepository extends JpaRepository<EventTicket, Long> {
    Page<EventTicket> findAllByIsActiveTrue(Pageable pageable);
    List<EventTicket> findAllByIsActiveTrue();
}
