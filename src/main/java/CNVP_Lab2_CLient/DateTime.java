package CNVP_Lab2_CLient;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateTime {
    public static String getDateTime() {
        ZonedDateTime dateTime = ZonedDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-yyyy ");
        String result = dateTime.format(formatter);
        return result;
    }
}
