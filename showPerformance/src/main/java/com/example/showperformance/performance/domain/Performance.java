package com.example.showperformance.performance.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class Performance {
    private String performId;
    private String performName;
    private String area;
    private String genreName;
    private String startDate;
    private String endDate;
    private String posterUrl;
}
