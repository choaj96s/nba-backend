package com.choaj96s.nbastats.service;

import com.choaj96s.nbastats.dto.GameSummaryResponse;
import com.choaj96s.nbastats.dto.SerpApiResponse;
import com.choaj96s.nbastats.dto.SportsResults;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
public class GameSummaryService {

    private final SerpAPIService serpApiService;
    private final GameSummaryAiService gameSummaryAiService;

    public Mono<GameSummaryResponse> generate(
            String date,
            String home,
            String visitor
    ) {
        String query = visitor + " vs " + home + " " + date + " NBA game recap";

        Mono<SerpApiResponse> gameInfo = serpApiService.searchGame(query);
        log.info("SEARCH GAME {}", gameInfo.block());
        return gameSummaryAiService.summarizeGame(date, home, visitor, gameInfo);
    }

    public Mono<SportsResults> generateHighlights(
            String date,
            String home,
            String visitor
    ) {
        String query = visitor + " vs " + home + " " + date + " NBA game recap";

        return serpApiService.searchGame(query)
                .doOnNext(response -> log.info("SEARCH GAME {}", response))
                .map(SerpApiResponse::getSportsResults);
    }
}