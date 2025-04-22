package com.example.showperformance.rank.controller.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@XmlAccessorType(XmlAccessType.FIELD)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class RankResponse {

    private String prfplcnm;
    private int seatcnt;
    private int rnum;
    private String poster;
    private String prfpd;
    private String mt20id;
    private String prfnm;
    private String cate;
    private int prfdtcnt;
    private String area;
}
