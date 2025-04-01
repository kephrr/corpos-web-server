package corpos.dakar.web_server.api.controllers.impl;

import corpos.dakar.web_server.api.controllers.EventController;
import corpos.dakar.web_server.api.dto.request.EventCreateDto;
import corpos.dakar.web_server.api.dto.response.EventDto;
import corpos.dakar.web_server.api.dto.response.RestResponseDto;
import corpos.dakar.web_server.data.entites.Event;
import corpos.dakar.web_server.data.enums.DeleteResults;
import corpos.dakar.web_server.data.enums.EventState;
import corpos.dakar.web_server.services.impl.EventServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/events")
public class EventControllerImpl implements EventController {
    private final EventServiceImpl eventService;

    @Override
    public Map<Object, Object> index() {
        List<EventDto> result = eventService.findAll().stream().map(EventDto::toDto).toList();
        return RestResponseDto.response(result, HttpStatus.OK);
    }

    @Override
    public Map<Object, Object> pages(int page, int size, Integer state) {
        Page<EventDto> results = eventService.findAll(PageRequest.of(page, size), EventState.values()[state]).map(EventDto::toDto);
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
        EventDto result = eventService.show(id).map(EventDto::toDto).orElse(null);
        return RestResponseDto.response(result, HttpStatus.OK);
    }

    @Override
    public Map<Object, Object> create(@Valid @RequestBody EventCreateDto dto,
                                      BindingResult bindingResult) {
        Map<Object, Object> response;
        if (bindingResult.hasErrors()){
            response = BaseImpl.bindErrors(bindingResult);
        }else{
            try {
                Event data = dto.toEntity();
                eventService.save(data);
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
        int isDeleted = eventService.delete(id);
        return RestResponseDto.response(DeleteResults.values()[isDeleted], HttpStatus.OK);
    }
}





