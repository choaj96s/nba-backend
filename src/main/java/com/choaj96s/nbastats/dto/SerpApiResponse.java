package com.choaj96s.nbastats.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class SerpApiResponse {
    private List<OrganicResult> organic_results;
    private List<InlineVideo> inline_videos;

    @JsonProperty("sports_results")
    private SportsResults sportsResults;
}

