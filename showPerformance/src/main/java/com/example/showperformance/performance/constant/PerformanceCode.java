package com.example.showperformance.performance.constant;

public enum PerformanceCode {

    THEATER("AAAA", "연극"),
    OCCIDENT_CLASSIC("CCCA", "서양 클래식"),
    KOREA_TRADITIONAL_MUSIC("CCCC", "한국 국악"),
    POP_MUSIC("CCCD", "대중 음악"),
    MUSICAL("GGGA", "뮤지컬");

    private final String code;
    private final String genre;

    PerformanceCode(String code, String genre) {
        this.code = code;
        this.genre = genre;
    }

    public static String code(String genre) {
        for (PerformanceCode performanceCode : values()) {
            if (performanceCode.genre.equals(genre)) {
                return performanceCode.code;
            }
        }
        return "ss";
    }
}
