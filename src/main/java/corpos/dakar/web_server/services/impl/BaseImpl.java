package corpos.dakar.web_server.services.impl;


import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseImpl {
    public static boolean isToday(String dateString, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        try {
            Date dateToCheck = sdf.parse(dateString);
            Date today = sdf.parse(sdf.format(new Date()));
            if (dateToCheck.equals(today)) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
