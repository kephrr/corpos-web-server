package corpos.dakar.web_server.services;

import corpos.dakar.web_server.data.entites.Event;

public interface IEventService extends IServiceCore<Event, Long> {
// Permettre de changer l'etat en une seule requete
    boolean checkCurrentEvent();
}
