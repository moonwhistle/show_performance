package com.example.showperformance.performance.infrastructure;

import com.example.showperformance.performance.domain.Performance;
import com.example.showperformance.common.util.DateUtil;
import com.example.showperformance.common.util.XmlParser;
import java.net.URI;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
@Slf4j
public class RestTemplatePerformanceRequester {

    private static final String DEFAULT_REQUEST_URL = "http://www.kopis.or.kr/openApi/restful/pblprfr";

    private final RestTemplate restTemplate;

    public List<Performance> requestPerformances(String apiKey, int nowPage, String genre) {
        RequestEntity<Void> requestEntity = RequestEntity
                .get(URI.create(makeUrl(apiKey, nowPage, genre)))
                .accept(MediaType.APPLICATION_XML)
                .build();

        String performanceData = restTemplate
                .exchange(requestEntity, String.class)
                .getBody();

        return XmlParser.parsePerformance(performanceData);
    }

    private String makeUrl(String apiKey, int nowPage, String genre) {

        return DEFAULT_REQUEST_URL +
                "?service=" + apiKey +
                "&stdate=" + DateUtil.getToday() +
                "&eddate=" + DateUtil.getAfterThirtyDays() +
                "&rows=10" +
                "&cpage=" + nowPage +
                "&shcate=" + genre;
    }
}
