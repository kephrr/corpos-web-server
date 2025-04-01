package corpos.dakar.web_server.repositories;

import corpos.dakar.web_server.data.entites.Event;
import corpos.dakar.web_server.data.entites.Ticket;
import corpos.dakar.web_server.data.enums.TicketState;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    @Query("SELECT DISTINCT t FROM Ticket t "+
            "WHERE t.isActive = true "+
            "AND (:state IS NULL OR t.state= :state) " +
            "AND (:event IS NULL OR t.event= :event) " +
            "ORDER BY t.orderingDate")
    Page<Ticket> findAllByIsActiveTrue(Pageable pageable, @Param("state") TicketState state, @Param("event") Event event);
    Page<Ticket> findAllByIsActiveTrue(Pageable pageable);
    List<Ticket> findAllByIsActiveTrue();
}
