package com.choaj96s.nbastats.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class GameSpotlight {
    private String league;
    private String stadium;

    @JsonProperty("stadium_kgmid")
    private String stadiumKgmid;

    private String date;
    private String status;

    @JsonProperty("video_highlight_carousel")
    private List<VideoHighlight> videoHighlightCarousel;

    private List<Team> teams;
    private String venue;
}
