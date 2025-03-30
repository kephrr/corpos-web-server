package corpos.dakar.web_server.api.controllers;

import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

public interface AnalyticsController {
    @GetMapping("/resume")
    Map<Object, Object> resume();
}
