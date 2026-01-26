package com.choaj96s.nbastats.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Score {
    @JsonProperty("1")
    private String quarter1;

    @JsonProperty("2")
    private String quarter2;

    @JsonProperty("3")
    private String quarter3;

    @JsonProperty("4")
    private String quarter4;

    @JsonProperty("T")
    private String total;
}
