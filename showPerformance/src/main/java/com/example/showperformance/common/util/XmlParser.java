package com.example.showperformance.common.util;

import com.example.showperformance.performance.infrastructure.dto.PerformanceDbs;
import com.example.showperformance.performance.infrastructure.dto.Performance;
import com.example.showperformance.rank.infrastructure.dto.Rankboxofs;
import com.example.showperformance.rank.infrastructure.dto.Rank;
import java.io.StringReader;
import java.util.List;
import java.util.stream.Collectors;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class XmlParser {

    public static List<Performance> parsePerformance(String xml) {
        try {
            JAXBContext context = JAXBContext.newInstance(PerformanceDbs.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            PerformanceDbs dbs = (PerformanceDbs) unmarshaller.unmarshal(new StringReader(xml));

            return dbs.getDbList()
                    .stream()
                    .map(performanceDb -> new Performance(
                                    performanceDb.getMt20id(),
                                    performanceDb.getPrfnm(),
                                    performanceDb.getArea(),
                                    performanceDb.getGenrenm(),
                                    performanceDb.getPrfpdfrom(),
                                    performanceDb.getPrfpdto(),
                                    performanceDb.getPoster()
                            )
                    )
                    .collect(Collectors.toList());

        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Rank> parseRanks(String xml) {
        try {
            JAXBContext context = JAXBContext.newInstance(Rankboxofs.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Rankboxofs ranks = (Rankboxofs) unmarshaller.unmarshal(new StringReader(xml));

            return ranks.getResponses()
                    .stream()
                    .map(rankResponse -> new Rank(
                            rankResponse.getPrfplcnm(),
                            rankResponse.getSeatcnt(),
                            rankResponse.getRnum(),
                            rankResponse.getPoster(),
                            rankResponse.getPrfpd(),
                            rankResponse.getMt20id(),
                            rankResponse.getPrfnm(),
                            rankResponse.getCate(),
                            rankResponse.getPrfdtcnt(),
                            rankResponse.getArea()
                    ))
                    .collect(Collectors.toList());

        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }
}
