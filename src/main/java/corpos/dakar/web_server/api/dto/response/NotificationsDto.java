package corpos.dakar.web_server.api.dto.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NotificationsDto {
    private int newTickets;
    private boolean isCurrentEvent;
}
