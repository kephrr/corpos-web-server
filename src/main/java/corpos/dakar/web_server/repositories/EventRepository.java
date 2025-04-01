package corpos.dakar.web_server.repositories;

import corpos.dakar.web_server.data.entites.Event;
import corpos.dakar.web_server.data.enums.EventState;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {
    @Query("SELECT DISTINCT e FROM Event e "+
            "WHERE e.isActive = true "+
            "AND (:state IS NULL OR e.state= :state) " +
            "ORDER BY e.date")
    Page<Event> findAllByIsActiveTrue(Pageable pageable,
                                      @Param("state") EventState state);
    /*@Query("SELECT DISTINCT e FROM Event e "+
            "WHERE e.isActive = true "+
            "ORDER BY e.date") */
    Page<Event> findAllByIsActiveTrue(Pageable pageable);
    List<Event> findAllByIsActiveTrue();
}







