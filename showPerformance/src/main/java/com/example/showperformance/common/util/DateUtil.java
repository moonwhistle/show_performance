package com.example.showperformance.common.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

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

    public static Date issuedDate() {
        return new Date(System.currentTimeMillis());
    }

    public static Date expiredDate(long expirationPeriod) {
        return new Date(System.currentTimeMillis() + expirationPeriod * 1000L); //2시간
    }
}
