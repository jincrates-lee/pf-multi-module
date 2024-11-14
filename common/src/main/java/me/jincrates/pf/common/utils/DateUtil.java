package me.jincrates.pf.common.utils;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateUtil {

    public static LocalDateTime getCurrentDateTime() {
        return LocalDateTime.now();
    }

    public static LocalDateTime parseIsoDateTime(String dateString) {
        return parseDateTime(
            dateString,
            DateTimeFormatter.ISO_DATE_TIME
        );
    }

    public static LocalDateTime parseDateTime(
        String dateString,
        DateTimeFormatter formatter
    ) {
        return LocalDateTime.parse(
            dateString,
            formatter
        );
    }

    public static LocalDateTime parseDateTime(
        String dateString,
        String pattern
    ) {
        return LocalDateTime.parse(
            dateString,
            DateTimeFormatter.ofPattern(pattern)
        );
    }

    public static String formatDefaultPattern(LocalDateTime date) {
        return formatPattern(
            date,
            "yyyy-MM-dd HH:mm:ss"
        );
    }

    public static String formatDefaultPattern(LocalTime time) {
        return formatPattern(
            time,
            "HH:mm:ss"
        );
    }

    public static String formatPattern(
        LocalTime time,
        String pattern
    ) {
        return time.format(DateTimeFormatter.ofPattern(pattern));
    }

    public static String formatPattern(
        LocalDateTime date,
        String pattern
    ) {
        return date.format(DateTimeFormatter.ofPattern(pattern));
    }
}
