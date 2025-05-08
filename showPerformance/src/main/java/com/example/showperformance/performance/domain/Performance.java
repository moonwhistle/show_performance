package com.example.showperformance.performance.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Performance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String performId;

    @Column
    private String performName;

    @Column
    private String area;

    @Column
    private String genreName;

    @Column
    private String startDate;

    @Column
    private String endDate;

    @Column
    private String posterUrl;

    public Performance(String performId, String performName, String area, String genreName, String startDate,
                       String endDate, String posterUrl) {
        this.performId = performId;
        this.performName = performName;
        this.area = area;
        this.genreName = genreName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.posterUrl = posterUrl;
    }
}
