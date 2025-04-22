package com.example.showperformance.performance.constant;

import com.example.showperformance.performance.exception.PerformanceErrorCode;
import com.example.showperformance.performance.exception.PerformanceException;

public enum AreaCode {

    SEOUL("11", "서울"),
    INCHEON("28", "인천"),
    GYEONGGI_DO("41", "경기");

    private final String code;
    private final String area;

    AreaCode(String code, String area) {
        this.code = code;
        this.area = area;
    }

    public static String code(String genre) {
        for (AreaCode areaCode : values()) {
            if (areaCode.area.equals(genre)) {
                return areaCode.code;
            }
        }
        throw new PerformanceException(PerformanceErrorCode.NOT_FOUND_GENRE);
    }
}
