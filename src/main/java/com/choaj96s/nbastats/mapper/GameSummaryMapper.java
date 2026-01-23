package com.choaj96s.nbastats.mapper;

import com.choaj96s.nbastats.dto.GameSummaryDto;
import com.choaj96s.nbastats.dto.KeyPlayerDto;
import com.choaj96s.nbastats.dto.TeamSummaryDto;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class GameSummaryMapper {

    public GameSummaryDto createSampleGameSummary() {
        TeamSummaryDto homeTeamSummary = new TeamSummaryDto(
                "Golden_State_Warriors",
                "win",
                "The Warriors showcased a dominant performance, leveraging their strong offense and solid defense to secure a convincing victory."
        );

        TeamSummaryDto visitorTeamSummary = new TeamSummaryDto(
                "Charlotte_Hornets",
                "loss",
                "The Hornets struggled to keep pace with the Warriors, facing challenges in both scoring and defense throughout the game."
        );

        List<KeyPlayerDto> homeTeamKeyPlayers = Arrays.asList(
                new KeyPlayerDto("Stephen Curry", "30 points, 8 assists"),
                new KeyPlayerDto("Klay Thompson", "25 points, 5 rebounds"),
                new KeyPlayerDto("Draymond Green", "10 points, 12 rebounds, 7 assists")
        );

        List<KeyPlayerDto> visitorTeamKeyPlayers = Arrays.asList(
                new KeyPlayerDto("LaMelo Ball", "22 points, 6 assists"),
                new KeyPlayerDto("Terry Rozier", "18 points, 4 rebounds"),
                new KeyPlayerDto("Miles Bridges", "15 points, 7 rebounds")
        );

        return new GameSummaryDto(homeTeamSummary, visitorTeamSummary, homeTeamKeyPlayers, visitorTeamKeyPlayers);
    }
}
