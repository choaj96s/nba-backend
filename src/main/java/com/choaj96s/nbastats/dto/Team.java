package com.choaj96s.nbastats.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Team {
    private String name;
    private String thumbnail;
    private String kgmid;

    @JsonProperty("team_stats")
    private TeamStats teamStats;

    private Score score;
}
