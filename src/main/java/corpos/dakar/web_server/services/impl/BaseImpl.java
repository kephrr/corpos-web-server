package corpos.dakar.web_server.services.impl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BaseImpl {
    public static boolean isToday(String dateString, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        LocalDate dateToCheck = LocalDate.parse(dateString, formatter);
        return dateToCheck.isEqual(LocalDate.now());
    }
}
