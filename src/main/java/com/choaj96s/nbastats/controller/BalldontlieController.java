package com.choaj96s.nbastats.controller;

import com.choaj96s.nbastats.dto.GamesResponseDto;
import com.choaj96s.nbastats.service.BalldontlieService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

@RestController
@CrossOrigin(
        origins = "*",
        allowedHeaders = "*",
        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS}
)
@RequestMapping("/api")
public class BalldontlieController {

    private final BalldontlieService balldontlieService;

    public BalldontlieController(BalldontlieService balldontlieService) {
        this.balldontlieService = balldontlieService;
    }

    @GetMapping("/teams")
    public String getTeams() {
        return balldontlieService.getTeams();
    }

    @GetMapping("/games")
    public GamesResponseDto getGames(
            @RequestParam(required = false) List<String> dates,
            @RequestParam(name = "team_ids", required = false) List<Integer> teamIds,
            @RequestParam(required = false) List<Integer> seasons,
            @RequestParam(required = false) Boolean postseason,
            @RequestParam(name = "start_date", required = false) String startDate,
            @RequestParam(name = "end_date", required = false) String endDate,
            @RequestParam(required = false) Integer cursor,
            @RequestParam(name = "per_page", required = false, defaultValue = "25") Integer perPage
    ) {
        return balldontlieService.getGames(dates, teamIds, seasons, postseason, startDate, endDate, cursor, perPage);
    }

//    @GetMapping("/game-summary")
//    public String getGameSummary(
//            @RequestParam(name = "start_date") String startDate,
//            @RequestParam(name = "end_date") String endDate,
//            @RequestParam(name = "home_team") String homeTeam,
//            @RequestParam(name = "visitor_team") String visitorTeam
//    ) {
//        return
//    }
}
