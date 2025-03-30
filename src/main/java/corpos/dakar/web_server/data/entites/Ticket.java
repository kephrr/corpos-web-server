package corpos.dakar.web_server.data.entites;

import corpos.dakar.web_server.data.enums.TicketState;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name="event_ticket")
public class Ticket extends AbstractEntity{
    private String name;
    private String telephone;
    private String email;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date orderingDate;
    @Enumerated(EnumType.STRING)
    private TicketState state;
    @ManyToOne
    private Event event;
}








