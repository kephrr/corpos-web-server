package corpos.dakar.web_server.services.impl;

import corpos.dakar.web_server.data.entites.Event;
import corpos.dakar.web_server.data.repositories.EventRepository;
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
        return eventRepository.findAll(pageable);
    }

    @Override
    public List<Event> findAll() {
        return eventRepository.findAll();
    }

    @Override
    public Optional<Event> show(Long dataID) {
        return eventRepository.findById(dataID);
    }
}
