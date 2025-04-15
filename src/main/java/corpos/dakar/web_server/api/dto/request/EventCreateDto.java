package corpos.dakar.web_server.api.dto.request;

import corpos.dakar.web_server.data.entites.Event;
import corpos.dakar.web_server.data.enums.EventState;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EventCreateDto {
    @NotNull(message = "Le libelle est obligatoire")
    private String libelle;
    private String description;
    @NotNull(message = "La date est obligatoire")
    private Date date;
    @NotNull(message = "La est obligatoire et positive")
    @Min(1)
    private Double duration;
    private int state;

    public Event toEntity(){
        return Event.builder()
                .libelle(this.getLibelle())
                .date(this.getDate())
                .duration(this.getDuration())
                .state(EventState.Created)
                .build();
    }
}












