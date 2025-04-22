package com.example.showperformance.common.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtil {

    private static final int ONE_MONTH = 30;
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyyMMdd");

    public static String getToday() {
        return LocalDate.now().format(FORMATTER);
    }

    public static String getAfterThirtyDays() {
        return LocalDate.now()
                .plusDays(ONE_MONTH)
                .format(FORMATTER);
    }

    public static String getBeforeThirtyDays() {
        return LocalDate.now()
                .minusDays(ONE_MONTH)
                .format(FORMATTER);
    }
}
