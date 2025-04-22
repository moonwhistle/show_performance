package com.example.showperformance.rank.infrastructure;

import com.example.showperformance.common.util.DateUtil;
import com.example.showperformance.common.util.XmlParser;
import com.example.showperformance.rank.infrastructure.dto.Rank;
import java.net.URI;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class RestTemplateRankRequester {

    private static final String DEFAULT_REQUEST_URL = "http://kopis.or.kr/openApi/restful/boxoffice";

    private final RestTemplate restTemplate;

    public List<Rank> requestRanks(String apiKey) {
        RequestEntity<Void> requestEntity = RequestEntity
                .get(URI.create(makeUrl(apiKey)))
                .accept(MediaType.APPLICATION_XML)
                .build();

        String rankData = restTemplate
                .exchange(requestEntity, String.class)
                .getBody();

        return XmlParser.parseRanks(rankData);
    }

    private String makeUrl(String apiKey) {

        return DEFAULT_REQUEST_URL +
                "?service=" + apiKey +
                "&stdate=" + DateUtil.getBeforeThirtyDays()+
                "&eddate=" + DateUtil.getToday();
    }
}
