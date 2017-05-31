package com.example.rechee.smsmanage;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

/**
 * Created by Rechee on 5/30/2017.
 */

public class DateUtilities {
    public static String getDate24HoursAgo() {
        return dateTimeToIso(DateTime.now().minusDays(1));
    }

    private static String dateTimeToIso(DateTime dateTime){
        DateTimeFormatter fmt = ISODateTimeFormat.dateTime();
        return fmt.print(dateTime);
    }

    public static String getCurrentTime(){
        return dateTimeToIso(DateTime.now());
    }
}
