package corpos.dakar.web_server.data.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TicketState {
    Valid(1),
    Invalid(2),
    Expired(3);
    private final Integer index;
}
