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
    private String description;
    private String date;
    private Double duration;
    private String state;
    private Integer stateIndex;

    public static EventDto toDto(Event e){
        return EventDto.builder()
                .libelle(e.getLibelle())
                .description(e.getDescription())
                .date(e.getDate().toString())
                .duration(e.getDuration())
                .state(e.getState().toString())
                .stateIndex(e.getState().getIndex())
                .build();
    }
}
