package com.example.showperformance.performance.controller.dto.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@XmlAccessorType(XmlAccessType.FIELD)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class PerformanceDb {
    private String mt20id;
    private String prfnm;
    private String genrenm;
    private String prfstate;
    private String prfpdfrom;
    private String prfpdto;
    private String poster;
    private String fcltynm;
    private String openrun;
    private String area;
}
