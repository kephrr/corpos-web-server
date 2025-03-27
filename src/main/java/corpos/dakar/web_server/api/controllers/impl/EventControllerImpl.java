package corpos.dakar.web_server.api.controllers.impl;

import corpos.dakar.web_server.api.controllers.EventController;
import corpos.dakar.web_server.api.dto.request.EventCreateDto;
import corpos.dakar.web_server.api.dto.response.EventDto;
import corpos.dakar.web_server.api.dto.response.RestResponseDto;
import corpos.dakar.web_server.data.entites.Event;
import corpos.dakar.web_server.data.enums.DeleteResults;
import corpos.dakar.web_server.data.repositories.EventRepository;
import corpos.dakar.web_server.data.repositories.EventTicketRepository;
import corpos.dakar.web_server.services.impl.EventServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/events")
public class EventControllerImpl implements EventController {
    private final EventServiceImpl eventservice;
    private final EventTicketRepository eventTicketRepository;

    @Override
    public Map<Object, Object> index() {
        List<EventDto> data = eventservice.findAll().stream().map(EventDto::toDto).toList();
        return RestResponseDto.response(data, HttpStatus.OK);
    }

    @Override
    public Map<Object, Object> pages(int page, int size) {
        Page<EventDto> results = eventservice.findAll(PageRequest.of(page, size)).map(EventDto::toDto);
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
        EventDto result = eventservice.show(id).map(EventDto::toDto).orElse(null);
        return RestResponseDto.response(result, HttpStatus.OK);
    }

    @Override
    public Map<Object, Object> create(@Valid @RequestBody EventCreateDto eventCreateDto,
                                      BindingResult bindingResult) {
        Map<Object, Object> response;
        if (bindingResult.hasErrors()){
            Map<String, String> errors =new HashMap<>();
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            fieldErrors.forEach(fieldError -> errors.put(fieldError.getField(),fieldError.getDefaultMessage()));
            response= RestResponseDto.response(errors, HttpStatus.NOT_ACCEPTABLE);
        }else{
            try {
                Event event = eventCreateDto.toEntity();
                eventservice.save(event);
                response= RestResponseDto.response(eventCreateDto,HttpStatus.CREATED);
            }catch (Exception e) {
                response= RestResponseDto.response(eventCreateDto,HttpStatus.NOT_ACCEPTABLE);
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
        int isDeleted = eventservice.delete(id);
        return RestResponseDto.response(DeleteResults.values()[isDeleted], HttpStatus.OK);
    }
}





