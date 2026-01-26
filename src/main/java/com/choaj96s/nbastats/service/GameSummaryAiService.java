package com.choaj96s.nbastats.service;

import com.choaj96s.nbastats.dto.GameSummaryResponse;
import com.choaj96s.nbastats.dto.OpenAiResponse;
import com.choaj96s.nbastats.dto.SerpApiResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class GameSummaryAiService {

    private final WebClient openAiWebClient;
    private final ObjectMapper objectMapper;

    public GameSummaryAiService(WebClient openAiWebClient, ObjectMapper objectMapper) {
        this.openAiWebClient = openAiWebClient;
        this.objectMapper = objectMapper;
    }

    public Mono<GameSummaryResponse> summarizeGame(String gameDate, String homeTeam, String visitorTeam, Mono<SerpApiResponse> serpApiResponse) {
        return serpApiResponse.flatMap(serpData -> {
            String userPrompt = """
                    Based on the following NBA game information, return a summary.

                    Return JSON using EXACTLY this schema:

                    {
                      "gameDate": "string",
                      "homeTeam": {
                        "teamName": "string",
                        "summary": "string"
                      },
                      "visitorTeam": {
                        "teamName": "string",
                        "summary": "string"
                      },
                      "homeTeamKeyPlayers": [
                        {
                          "name": "string",
                          "statLine": "string"
                        }
                      ],
                      "visitorTeamKeyPlayers": [
                        {
                          "name": "string",
                          "statLine": "string"
                        }
                      ],
                      "highlights": [
                        {
                          "title": "string",
                          "youtubeUrl": "string",
                          "thumbnail" : "string"
                        }
                      ]
                    }

                    Game info:
                    - Game Date: %s
                    - Home Team: %s
                    - Visitor Team: %s
                    - Search Data: %s
                    """.formatted(gameDate, homeTeam, visitorTeam, serpData);

            Map<String, Object> requestBody = new HashMap<>();
            requestBody.put("model", "gpt-4o-mini");
            requestBody.put("temperature", 0.2);
            requestBody.put("messages", List.of(
                    Map.of(
                            "role", "system",
                            "content",
                            "You are a backend service that outputs JSON only. " +
                                    "Do not include explanations, markdown, or code blocks."
                    ),
                    Map.of(
                            "role", "user",
                            "content", userPrompt
                    )
            ));

            log.info("REQUEST BODY: {}", requestBody);

            return openAiWebClient.post()
                    .uri("/chat/completions")
                    .bodyValue(requestBody)
                    .retrieve()
                    .bodyToMono(OpenAiResponse.class)
                    .map(resp -> resp.getChoices().get(0).getMessage().getContent())
                    .doOnNext(json -> log.info("AI RAW JSON:\n{}", json))
                    .map(this::parseJson);
        });
    }

    private GameSummaryResponse parseJson(String json) {
        try {
            return objectMapper.readValue(json, GameSummaryResponse.class);
        } catch (Exception e) {
            throw new RuntimeException("Failed to parse AI JSON", e);
        }
    }
}
