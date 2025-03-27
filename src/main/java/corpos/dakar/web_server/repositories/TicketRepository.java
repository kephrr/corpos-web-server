package corpos.dakar.web_server.repositories;

import corpos.dakar.web_server.data.entites.Ticket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    Page<Ticket> findAllByIsActiveTrue(Pageable pageable);
    List<Ticket> findAllByIsActiveTrue();
}
