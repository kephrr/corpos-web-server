package corpos.dakar.web_server.api.dto.request;


import corpos.dakar.web_server.data.entites.Ticket;
import corpos.dakar.web_server.data.enums.TicketState;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TicketCreateDto {
    @NotBlank
    private String name;
    @NotBlank
    private String telephone;
    private String email;
    @NotBlank
    private Integer state;
    @NotBlank
    private Long eventId;

    public Ticket toEntity(){
        return Ticket.builder()
                .email(this.email)
                .name(this.name)
                .telephone(this.telephone)
                .state(TicketState.Valid)
                .build();
    }
}












