package com.choaj96s.nbastats.controller;

import com.choaj96s.nbastats.dto.GameSummaryResponse;
import com.choaj96s.nbastats.dto.SerpApiResponse;
import com.choaj96s.nbastats.dto.SportsResults;
import com.choaj96s.nbastats.service.GameSummaryService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(
        origins = "*",
        allowedHeaders = "*",
        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS}
)
@RequestMapping("/api")
public class SerpAPIController {
    private final GameSummaryService gameSummaryService;

    public SerpAPIController(GameSummaryService gameSummaryService) {
        this.gameSummaryService = gameSummaryService;
    }

    @GetMapping("/game-summary-skrt")
    public Mono<GameSummaryResponse> getGameSummary(
            @RequestParam(name = "game_date") String gameDate,
            @RequestParam(name = "home_team") String homeTeam,
            @RequestParam(name = "visitor_team") String visitorTeam
    ) {
        return gameSummaryService.generate(gameDate, homeTeam, visitorTeam);
    }

    @GetMapping("/game-highlights")
    public Mono<SportsResults> getGameHighlights(
            @RequestParam(name = "game_date") String gameDate,
            @RequestParam(name = "home_team") String homeTeam,
            @RequestParam(name = "visitor_team") String visitorTeam
    ) {
        return gameSummaryService.generateHighlights(gameDate, homeTeam, visitorTeam);
    }
}
