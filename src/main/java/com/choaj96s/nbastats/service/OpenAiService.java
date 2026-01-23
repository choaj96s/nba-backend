package com.choaj96s.nbastats.service;

import com.choaj96s.nbastats.dto.GameSummaryDto;
import com.choaj96s.nbastats.dto.OpenAiRequest;
import com.choaj96s.nbastats.dto.OpenAiResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class OpenAiService {

    private final WebClient openAiWebClient;
    private final ObjectMapper objectMapper;

    public OpenAiService(WebClient openAiWebClient, ObjectMapper objectMapper) {
        this.openAiWebClient = openAiWebClient;
        this.objectMapper = objectMapper;
    }

    public GameSummaryDto summarizeGame(String startDate, String endDate, String homeTeam, String visitorTeam) {
        OpenAiRequest request = new OpenAiRequest(
                "gpt-4o-mini",
                List.of(
                        new OpenAiRequest.Message(
                                "system",
                                """
                                You are a strict JSON API.
                                You must return ONLY JSON, no markdown, no explanation, no commentary.
                                Do NOT include citations, contentReference, or any extra fields.
                                """
                        ),
                        new OpenAiRequest.Message(
                                "user",
                                String.format("""
                                Based on the provided game data, summarize the performance of both teams.

                                Requirements:
                                - Always return JSON ONLY
                                - JSON MUST follow this schema:

                                {
                                  "home_team_summary": {
                                    "team": "string",
                                    "result": "string",
                                    "summary": "string"
                                  },
                                  "visitor_team_summary": {
                                    "team": "string",
                                    "result": "string",
                                    "summary": "string"
                                  },
                                  "home_team_key_players": [
                                    { "name": "string", "performance": "string" },
                                    { "name": "string", "performance": "string" },
                                    { "name": "string", "performance": "string" }
                                  ],
                                  "visitor_team_key_players": [
                                    { "name": "string", "performance": "string" },
                                    { "name": "string", "performance": "string" },
                                    { "name": "string", "performance": "string" }
                                  ]
                                }

                                Game Details:
                                - Start Date: %s
                                - End Date: %s
                                - Home Team: %s
                                - Visitor Team: %s
                                """, startDate, endDate, homeTeam, visitorTeam)
                        )
                ),
                0.0,
                new OpenAiRequest.ResponseFormat("json_object")
        );

        OpenAiResponse response = openAiWebClient.post()
                .uri("/chat/completions")
                .bodyValue(request)
                .retrieve()
                .bodyToMono(OpenAiResponse.class)
                .block();

        String jsonContent = response.getChoices().get(0).getMessage().getContent();

        try {
            return objectMapper.readValue(jsonContent, GameSummaryDto.class);
        } catch (Exception e) {
            throw new RuntimeException("Failed to parse game summary JSON", e);
        }
    }
}
