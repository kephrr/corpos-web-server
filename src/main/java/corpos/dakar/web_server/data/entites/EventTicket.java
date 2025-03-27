package corpos.dakar.web_server.data.entites;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
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
    @ManyToOne
    private Event event;
}
