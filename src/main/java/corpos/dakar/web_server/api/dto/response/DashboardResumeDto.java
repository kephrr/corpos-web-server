package corpos.dakar.web_server.api.dto.response;

import corpos.dakar.web_server.data.entites.Event;
import corpos.dakar.web_server.data.entites.Ticket;
import lombok.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DashboardResumeDto {
    private Integer totalTickets= 0;
    private Integer thisWeek= 0;
    private Integer thisMonth= 0;
    private Integer lastMonth = 0;
    private Double thisMonthDifferential= 0.0;
    private Integer remainingEvents= 0;

    public void calculate(List<Ticket> tickets, List<Event> events) {
        // Total tickets
        this.totalTickets = tickets.size();
        Date today = new Date();
        int currentMonth = today.getMonth();
        int pastMonth;
        if(currentMonth == 0) pastMonth = 11; else pastMonth = currentMonth - 1;
        tickets.forEach(ticket -> {
            if(today.after(ticket.getOrderingDate()) ) {
                // This month tickets
                if(currentMonth == ticket.getOrderingDate().getMonth()) this.thisMonth ++;
                // Last month tickets
                if(pastMonth == ticket.getOrderingDate().getMonth()) this.lastMonth++;
            }
        });
        // This month differential
        if(this.lastMonth!=0) this.thisMonthDifferential = (double) (((this.totalTickets - this.lastMonth) * 100 / this.lastMonth) - 100);
        else this.thisMonthDifferential = 99.99;
        // Remaining events
        events.forEach(event -> {
           if(event.getDate().after(today)) {
               this.remainingEvents++;
           }
        });
    }

    public boolean sameWeek(Date d1, Date d2) {
        Date firstMonday, secondMonday;
        /*
        * 1. Déterminer le début de la semaine de la première date
        *    Déterminer le début de semaine de la deuxième date
        *    Si les deux dates ont le même début de semaine, alors c'est la même semaine
        * */
        if(d1.getDay() == 1){
            firstMonday = d1;
        }else{
            Date day = d1;
            do{
                // Récupérer le jour précédent à une date day et le stocker dans day
            }while(day.getDay()!=1);
        }
        return true;
    }
}











