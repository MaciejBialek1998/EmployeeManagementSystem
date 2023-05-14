package pl.bialek.managementsystem3.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class DateUtils {

    public static String formatDate(Date date){
        SimpleDateFormat dateFormat
                = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(date);
    }

    public static Date formatStringToDate(String date){
        if(date.equals("")){
            date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        }

        try {
            return new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).parse(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

}
