package corpos.dakar.web_server.services.impl;

import corpos.dakar.web_server.data.entites.Event;
import corpos.dakar.web_server.data.enums.EventState;
import corpos.dakar.web_server.repositories.EventRepository;
import corpos.dakar.web_server.services.IEventService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements IEventService {
    private final EventRepository eventRepository;
    @Override
    public Event save(Event data) {
        return eventRepository.save(data);
    }

    @Override
    public Page<Event> findAll(Pageable pageable) {
        return eventRepository.findAllByIsActiveTrue(pageable);
    }

    @Override
    public List<Event> findAll() {
        return eventRepository.findAllByIsActiveTrue();
    }

    @Override
    public Optional<Event> show(Long dataID) {
        return eventRepository.findById(dataID);
    }

    @Override
    public int delete(Long dataID) {
        Event event = show(dataID).orElse(null);
        if(event != null) {
            event.setIsActive(false);
            eventRepository.save(event);
            return 1;
        }
        return 0;
    }

    @Override
    public boolean checkCurrentEvent() {
        for(Event event : findAll()){
            if(event.getState()== EventState.EnCours) {
                return true;
            }
        };
        return false;
    }
}







