package corpos.dakar.web_server.services.impl;

import corpos.dakar.web_server.Config;
import corpos.dakar.web_server.data.entites.Ticket;
import corpos.dakar.web_server.repositories.TicketRepository;
import corpos.dakar.web_server.services.ITicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl extends BaseImpl implements ITicketService {
    private final TicketRepository ticketRepository;
    @Override
    public Ticket save(Ticket data) {
        return ticketRepository.save(data);
    }

    @Override
    public Page<Ticket> findAll(Pageable pageable) {
        return ticketRepository.findAllByIsActiveTrue(pageable);
    }

    @Override
    public List<Ticket> findAll() {
        return ticketRepository.findAllByIsActiveTrue();
    }

    @Override
    public Optional<Ticket> show(Long dataID) {
        return ticketRepository.findById(dataID);
    }

    @Override
    public int delete(Long dataID) {
        Ticket ticket = show(dataID).orElse(null);
        if(ticket != null) {
            ticket.setIsActive(false);
            ticketRepository.save(ticket);
            return 1;
        }
        return 0;
    }

    @Override
    public int checkNewTickets() {
        int count = 0;
        for(Ticket ticket :  findAll()){
            if(isToday(ticket.getOrderingDate().toString(), Config.dateFormatPattern)){
                count++;
            }
        }
        return count;
    }
}








