package CNVP_Lab2_CLient;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeHelper {
    public static String getFormattedDateTime() {
        ZonedDateTime dateTime = ZonedDateTime.now();//  TODO:use UTC
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-yyyy");
        String result = dateTime.format(formatter);
        return result;
    }
}
