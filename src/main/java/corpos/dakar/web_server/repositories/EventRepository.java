package corpos.dakar.web_server.repositories;

import corpos.dakar.web_server.data.entites.Event;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {
    Page<Event> findAllByIsActiveTrue(Pageable pageable);
    List<Event>  findAllByIsActiveTrue();
}
