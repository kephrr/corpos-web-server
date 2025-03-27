package corpos.dakar.web_server.api.dto.response;

import corpos.dakar.web_server.data.entites.Event;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EventDto {
    private String libelle;
    private String date;
    private Double duration;
    private String state;

    public static EventDto toDto(Event e){
        return EventDto.builder()
                .libelle(e.getLibelle())
                .date(e.getDate().toString())
                .duration(e.getDuration())
                .state(e.getState().toString())
                .build();
    }
}
