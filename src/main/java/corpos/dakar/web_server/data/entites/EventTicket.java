package corpos.dakar.web_server.data.entites;

import corpos.dakar.web_server.data.enums.TicketState;
import jakarta.persistence.*;
import lombok.*;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name="event_ticket")
public class EventTicket extends AbstractEntity{
    private String name;
    private String telephone;
    private String email;
    @Enumerated(EnumType.STRING)
    private TicketState state;
    @ManyToOne
    private Event event;
}








