package com.example.showperformance.performance.infrastructure.dto;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@XmlAccessorType(XmlAccessType.FIELD)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class DetailPerformanceDb {

    private String mt20id;
    private String prfnm;
    private String prfpdfrom;
    private String prfpdto;
    private String fcltynm;
    private String prfcast;
    private String prfcrew;
    private String prfruntime;
    private String prfage;
    private String entrpsnm;
    private String entrpsnmP;
    private String entrpsnmA;
    private String entrpsnmH;
    private String entrpsnmS;
    private String pcseguidance;
    private String poster;
    private String sty;
    private String area;
    private String genrenm;
    private String openrun;
    private String visit;
    private String child;
    private String daehakro;
    private String festival;
    private String musicallicense;
    private String musicalcreate;
    private String updatedate;
    private String prfstate;
    private String mt10id;
    private String dtguidance;

    @XmlElementWrapper(name = "styurls")
    @XmlElement(name = "styurl")
    private List<String> styurls;

    @XmlElementWrapper(name = "relates")
    @XmlElement(name = "relate")
    private List<Relate> relates;
}
