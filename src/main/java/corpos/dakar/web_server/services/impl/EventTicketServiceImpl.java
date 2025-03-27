package corpos.dakar.web_server.services.impl;

import corpos.dakar.web_server.data.entites.EventTicket;
import corpos.dakar.web_server.data.repositories.EventTicketRepository;
import corpos.dakar.web_server.services.IEventTicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EventTicketServiceImpl implements IEventTicketService {
    private final EventTicketRepository eventTicketRepository;
    @Override
    public EventTicket save(EventTicket data) {
        return eventTicketRepository.save(data);
    }

    @Override
    public Page<EventTicket> findAll(Pageable pageable) {
        return eventTicketRepository.findAll(pageable);
    }

    @Override
    public List<EventTicket> findAll() {
        return eventTicketRepository.findAll();
    }

    @Override
    public Optional<EventTicket> show(Long dataID) {
        return eventTicketRepository.findById(dataID);
    }
}
