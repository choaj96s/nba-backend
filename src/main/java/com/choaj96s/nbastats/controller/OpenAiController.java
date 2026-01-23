package com.choaj96s.nbastats.controller;

import com.choaj96s.nbastats.dto.GameSummaryDto;
import com.choaj96s.nbastats.service.BalldontlieService;
import com.choaj96s.nbastats.service.OpenAiService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(
        origins = "*",
        allowedHeaders = "*",
        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS}
)
@RequestMapping("/api")
public class OpenAiController {
    private final OpenAiService openAiService;
    public OpenAiController(
            OpenAiService openAiService) {
        this.openAiService = openAiService;
    }

    @GetMapping("/game-summary")
    public GameSummaryDto getGameSummary(
            @RequestParam(name = "start_date") String startDate,
            @RequestParam(name = "end_date") String endDate,
            @RequestParam(name = "home_team") String homeTeam,
            @RequestParam(name = "visitor_team") String visitorTeam
    ) {
        return openAiService.summarizeGame(startDate, endDate, homeTeam, visitorTeam);
    }
}
