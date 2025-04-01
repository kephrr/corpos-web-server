package corpos.dakar.web_server.api.controllers.impl;

import corpos.dakar.web_server.api.controllers.TicketController;
import corpos.dakar.web_server.api.dto.request.TicketCreateDto;
import corpos.dakar.web_server.api.dto.response.RestResponseDto;
import corpos.dakar.web_server.api.dto.response.TicketDto;
import corpos.dakar.web_server.data.entites.Event;
import corpos.dakar.web_server.data.entites.Ticket;
import corpos.dakar.web_server.data.enums.DeleteResults;
import corpos.dakar.web_server.data.enums.TicketState;
import corpos.dakar.web_server.services.IEventService;
import corpos.dakar.web_server.services.ITicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tickets")
public class TicketControllerImpl implements TicketController {
    private final ITicketService ticketService;
    private final IEventService eventService;
    @Override
    public Map<Object, Object> index() {
        List<TicketDto> result = ticketService.findAll().stream().map(TicketDto::toDto).toList();
        return RestResponseDto.response(result, HttpStatus.OK);
    }

    @Override
    public Map<Object, Object> pages(int page, int size, Integer state, Long eventId) {
        Event event = eventService.show(eventId).orElse(null);
        Page<TicketDto> results = ticketService.findAll(PageRequest.of(page, size), TicketState.values()[state],event).map(TicketDto::toDto);
        return RestResponseDto.response(
                results.getContent(),
                new int[results.getTotalPages()],
                page,
                results.getTotalElements(),
                results.getTotalPages(),
                HttpStatus.OK
        );
    }

    @Override
    public Map<Object, Object> show(Long id) {
        Ticket result = ticketService.show(id).orElse(null);
        return RestResponseDto.response(result, HttpStatus.OK);
    }

    @Override
    public Map<Object, Object> create(TicketCreateDto dto, BindingResult bindingResult) {
        Map<Object, Object> response;
        if (bindingResult.hasErrors()){
            response = BaseImpl.bindErrors(bindingResult);
        }else{
            try {
                Ticket data = dto.toEntity();
                Event event = eventService.show(dto.getEventId()).orElse(null);
                data.setEvent(event);
                ticketService.save(data);
                response= RestResponseDto.response(dto,HttpStatus.CREATED);
            }catch (Exception e) {
                response= RestResponseDto.response(dto,HttpStatus.NOT_ACCEPTABLE);
                System.out.println(e.getMessage());
            }
        }
        return RestResponseDto.response(
                response,
                HttpStatus.OK
        );
    }

    @Override
    public Map<Object, Object> delete(Long id) {
        int isDeleted = ticketService.delete(id);
        return RestResponseDto.response(DeleteResults.values()[isDeleted], HttpStatus.OK);
    }
}
