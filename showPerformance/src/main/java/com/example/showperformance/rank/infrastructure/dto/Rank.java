package com.example.showperformance.rank.infrastructure.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Rank {
    private String placeName;
    private int seatCount;
    private int rank;
    private String posterUrl;
    private String period;
    private String performanceId;
    private String performanceName;
    private String category;
    private int performanceCount;
    private String area;
}
