package corpos.dakar.web_server.api.controllers;

import corpos.dakar.web_server.api.dto.request.TicketCreateDto;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

public interface TicketController {
    @GetMapping("")
    Map<Object, Object> index();

    @GetMapping("/paginate")
    Map<Object, Object> pages(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(required = false) Integer state
    );

    @GetMapping("/{id}")
    Map<Object, Object> show(@PathVariable Long id);

    @PostMapping("")
    Map<Object, Object> create(
            @Valid @RequestBody TicketCreateDto dto,
            BindingResult bindingResult
            );

    @GetMapping("/delete/{id}")
    Map<Object, Object> delete(@PathVariable Long id);

    @GetMapping("/invalidate/{id}")
    Map<Object, Object> invalidate(@PathVariable Long id);
}






