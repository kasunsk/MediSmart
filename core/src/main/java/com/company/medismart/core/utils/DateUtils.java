package com.company.medismart.core.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateUtils {

    private static final SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static final DateTimeFormatter localDateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public static String toSimpleDate(Date date) {

        if (date == null) {
            return null;
        }
        return sdf.format(date);
    }

    public static String toSimpleDateWithoutTime(Date date) {

        if (date == null) {
            return null;
        }
        return sf.format(date);
    }

    public static Date fromSimpleDateStringToDate(String dateString) throws ParseException {

        if (dateString == null || dateString.isEmpty()) {
            return null;
        }
        return sdf.parse(dateString);
    }
}

