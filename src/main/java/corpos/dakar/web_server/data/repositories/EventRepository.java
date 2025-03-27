package corpos.dakar.web_server.data.repositories;

import corpos.dakar.web_server.data.entites.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
