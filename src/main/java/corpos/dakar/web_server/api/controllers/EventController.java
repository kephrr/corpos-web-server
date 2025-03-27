package corpos.dakar.web_server.api.controllers;

import corpos.dakar.web_server.api.dto.request.EventCreateDto;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

public interface EventController {
    @GetMapping("/")
    Map<Object, Object> index();

    @GetMapping("/paginate")
    Map<Object, Object> pages(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    );

    @GetMapping("/{id}")
    Map<Object, Object> show(@PathVariable Long id);

    @PostMapping("/")
    Map<Object, Object> create(
            @Valid @RequestBody EventCreateDto eventCreateDto,
            BindingResult bindingResult
            );

    @GetMapping("/delete/{id}")
    Map<Object, Object> delete(@PathVariable Long id);
}






