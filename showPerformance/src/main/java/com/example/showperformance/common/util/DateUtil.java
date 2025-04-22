package com.example.showperformance.common.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtil {

    private static final int PLUS_ONE_MONTH = 30;
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyyMMdd");

    public static String getToday() {
        return LocalDate.now().format(FORMATTER);
    }

    public static String getAfter30Days() {
        return LocalDate.now().plusDays(PLUS_ONE_MONTH).format(FORMATTER);
    }
}
