package corpos.dakar.web_server.data.entites;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;
import java.util.List;
import lombok.*;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name="event")
public class Event extends AbstractEntity{
    private String libelle;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
    private Double duration;
    @OneToMany(mappedBy = "event")
    List<EventTicket> tickets;
}











