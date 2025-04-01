package corpos.dakar.web_server.api.controllers.impl;

import corpos.dakar.web_server.api.controllers.AnalyticsController;
import corpos.dakar.web_server.api.dto.response.DashboardResumeDto;
import corpos.dakar.web_server.api.dto.response.NotificationsDto;
import corpos.dakar.web_server.api.dto.response.RestResponseDto;
import corpos.dakar.web_server.services.IEventService;
import corpos.dakar.web_server.services.ITicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stats")
public class AnalyticsControllerImpl implements AnalyticsController {
    private final ITicketService ticketService;
    private final IEventService eventService;
    @Override
    public Map<Object, Object> resume() {
        DashboardResumeDto resume = new DashboardResumeDto();
        resume.calculate(ticketService.findAll(), eventService.findAll());
        return RestResponseDto.response(resume, HttpStatus.OK);
    }

    @Override
    public Map<Object, Object> notifications() {
        boolean isCurrentEvent = eventService.checkCurrentEvent();
        int newTickets = ticketService.checkNewTickets();
        NotificationsDto response = new NotificationsDto(newTickets, isCurrentEvent);
        return RestResponseDto.response(response, HttpStatus.OK);
    }
}









