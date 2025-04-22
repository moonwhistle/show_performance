package com.example.showperformance.performance.infrastructure.dto;

import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DetailPerformance {

    private String mt20id;         // 공연 ID
    private String prfnm;          // 공연명
    private String prfpdfrom;      // 시작일
    private String prfpdto;        // 종료일
    private String fcltynm;        // 시설명
    private String prfcast;        // 출연진
    private String prfcrew;        // 제작진
    private String prfruntime;     // 공연 시간
    private String prfage;         // 관람 연령
    private String entrpsnm;       // 기업명
    private String entrpsnmP;      // P 기업명
    private String entrpsnmA;      // A 기업명
    private String entrpsnmH;      // H 기업명
    private String entrpsnmS;      // S 기업명
    private String pcseguidance;   // 가격 안내
    private String poster;         // 포스터 이미지 URL
    private String sty;            // 스타일
    private String area;           // 지역
    private String genrenm;        // 장르
    private String openrun;        // 오픈런 여부
    private String visit;          // 방문 여부
    private String child;          // 어린이 입장 여부
    private String daehakro;       // 대학로 여부
    private String festival;       // 페스티벌 여부
    private String musicallicense; // 뮤지컬 라이선스 여부
    private String musicalcreate;  // 뮤지컬 창작 여부
    private String updatedate;     // 업데이트 일자
    private String prfstate;       // 공연 상태
    private String mt10id;         // 공연 ID (추가)
    private String dtguidance;     // 날짜 및 시간 안내
    private List<String> styurls;  // 스타일 URL 리스트
    private List<Relate> relates;  // 관련 링크들
}
