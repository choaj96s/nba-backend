package com.choaj96s.nbastats.service;

import com.choaj96s.nbastats.dto.GamesResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Slf4j
@Service
public class BalldontlieService {

    private final WebClient webClient;
    private final SecretService secretService;

    public BalldontlieService(WebClient webClient, SecretService secretService) {
        this.webClient = webClient;
        this.secretService = secretService;
    }

    public String getTeams() {
        String apiKey = secretService.getBallDontLieSecret().trim();

        return webClient.get()
                .uri("/teams")
                .header("Authorization", apiKey)
                .retrieve()
                .bodyToMono(String.class)
                .block();   // 현재는 blocking 방식으로 간단히 처리
    }

    public GamesResponseDto getGames(List<String> dates, List<Integer> teamIds, List<Integer> seasons,
                                       Boolean postseason, String startDate, String endDate,
                                       Integer cursor, Integer perPage) {
        String apiKey = secretService.getBallDontLieSecret().trim();

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromPath("/games");

        if (dates != null && !dates.isEmpty()) {
            dates.forEach(date -> uriBuilder.queryParam("dates[]", date));
        }

        if (teamIds != null && !teamIds.isEmpty()) {
            teamIds.forEach(teamId -> uriBuilder.queryParam("team_ids[]", teamId));
        }

        if (seasons != null && !seasons.isEmpty()) {
            seasons.forEach(season -> uriBuilder.queryParam("seasons[]", season));
        }

        if (postseason != null) {
            uriBuilder.queryParam("postseason", postseason);
        }

        if (startDate != null && !startDate.isEmpty()) {
            uriBuilder.queryParam("start_date", startDate);
        }

        if (endDate != null && !endDate.isEmpty()) {
            uriBuilder.queryParam("end_date", endDate);
        }

        if (cursor != null) {
            uriBuilder.queryParam("cursor", cursor);
        }

        if (perPage != null) {
            uriBuilder.queryParam("per_page", perPage);
        }

        String uri = uriBuilder.build().toUriString();
        log.info("URI: {}", uri);

        return webClient.get()
                .uri(uri)
                .header("Authorization", apiKey)
                .retrieve()
                .bodyToMono(GamesResponseDto.class)
                .block();
    }
}
