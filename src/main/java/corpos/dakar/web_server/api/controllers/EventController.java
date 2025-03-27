package corpos.dakar.web_server.api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

public interface EventController {
    @GetMapping("/")
    String index();

    @GetMapping("/{id}")
    String show(@PathVariable int id);

    @PostMapping("/")
    String create();
}
