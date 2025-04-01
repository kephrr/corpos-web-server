package corpos.dakar.web_server.services;

import corpos.dakar.web_server.data.entites.Event;
import corpos.dakar.web_server.data.enums.EventState;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IEventService extends IServiceCore<Event, Long> {
// Permettre de changer l'etat en une seule requete
    boolean checkCurrentEvent();
    Page<Event> findAll(Pageable pageable, EventState state);
}
