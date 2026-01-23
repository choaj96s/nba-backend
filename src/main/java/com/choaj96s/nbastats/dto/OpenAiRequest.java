package com.choaj96s.nbastats.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OpenAiRequest {
    private String model;
    private List<Message> messages;
    private Double temperature;

    @JsonProperty("response_format")
    private ResponseFormat responseFormat;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Message {
        private String role;   // system | user
        private String content;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ResponseFormat {
        private String type;  // "json_object" or "text"
    }
}
