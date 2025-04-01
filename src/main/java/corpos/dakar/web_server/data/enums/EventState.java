package corpos.dakar.web_server.data.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum EventState {
    Created(1),
    Available(2),
    Resumed(3),
    Unavailable(4),
    EnCours(5);
    private final Integer index;
}










