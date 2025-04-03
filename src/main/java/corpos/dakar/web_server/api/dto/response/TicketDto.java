package corpos.dakar.web_server.api.dto.response;

import corpos.dakar.web_server.data.entites.Ticket;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TicketDto {
    private String name;
    private String telephone;
    private String email;
    private String event;
    private String state;
    private Integer stateIndex;
    private String orderingDate;

    public static TicketDto toDto(Ticket ticket) {
        String event = "Indéfini";
        if(ticket.getEvent() != null) {
            event = ticket.getEvent().getLibelle();
        }
        return TicketDto.builder()
                .name(ticket.getName())
                .telephone(ticket.getTelephone())
                .email(ticket.getEmail())
                .event(event)
                .state(ticket.getState().toString())
                .stateIndex(ticket.getState().getIndex())
                .orderingDate(ticket.getOrderingDate().toString())
                .build();
    }
}










