package com.example.showperformance.performance.infrastructure.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Performance {
    private String performId;
    private String performName;
    private String area;
    private String genreName;
    private String startDate;
    private String endDate;
    private String posterUrl;
}
