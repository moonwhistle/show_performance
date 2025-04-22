package com.example.showperformance.rank.controller.dto;

import com.example.showperformance.rank.domain.Rank;
import java.util.List;

public record RankResponses(
        List<Rank> ranks
) {
}
