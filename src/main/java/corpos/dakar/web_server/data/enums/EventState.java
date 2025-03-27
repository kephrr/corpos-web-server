package corpos.dakar.web_server.data.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum EventState {
    Created(1),
    Available(2),
    Public(3),
    Private(4),
    Resumed(5);
    private final Integer index;
}










