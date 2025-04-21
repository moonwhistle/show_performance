package com.example.showperformance.performance.controller.dto;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.NoArgsConstructor;

@XmlRootElement(name = "dbs")
@XmlAccessorType(XmlAccessType.FIELD)
@NoArgsConstructor
@Getter
public class PerformanceDbs {

    @XmlElement(name = "db")
    private List<PerformanceDb> dbList;
}
