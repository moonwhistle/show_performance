package com.example.showperformance.performance.constant;

import com.example.showperformance.performance.exception.PerformanceErrorCode;
import com.example.showperformance.performance.exception.PerformanceException;

public enum GenreCode {

    THEATER("AAAA", "연극"),
    OCCIDENT_CLASSIC("CCCA", "서양 클래식"),
    KOREA_TRADITIONAL_MUSIC("CCCC", "한국 국악"),
    POP_MUSIC("CCCD", "대중 음악"),
    MUSICAL("GGGA", "뮤지컬");

    private final String code;
    private final String genre;

    GenreCode(String code, String genre) {
        this.code = code;
        this.genre = genre;
    }

    public static String code(String genre) {
        for (GenreCode genreCode : values()) {
            if (genreCode.genre.equals(genre)) {
                return genreCode.code;
            }
        }
        throw new PerformanceException(PerformanceErrorCode.NOT_FOUND_AREA);
    }
}
