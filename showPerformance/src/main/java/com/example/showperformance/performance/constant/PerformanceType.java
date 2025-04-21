package com.example.showperformance.performance.constant;

public enum PerformanceType {

    THEATER("AAAA", "연극"),
    OCCIDENT_CLASSIC("CCCA", "서양 클래식"),
    KOREA_TRADITIONAL_MUSIC("CCCC", "한국 국악"),
    POP_MUSIC("CCCD", "대중 음악"),
    MUSICAL("GGGA", "뮤지컬");

    private final String code;
    private final String type;

    PerformanceType(String code, String type) {
        this.code = code;
        this.type = type;
    }

    private String code() {
        return code;
    }

    private String type() {
        return type;
    }
}
