package com.example.showperformance.performance.infrastructure.util;

import com.example.showperformance.performance.controller.dto.PerformanceDbs;
import com.example.showperformance.performance.domain.Performance;
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
}
