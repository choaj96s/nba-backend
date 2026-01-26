package com.choaj96s.nbastats.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SportsResults {
    @JsonProperty("game_spotlight")
    private GameSpotlight gameSpotlight;
}
