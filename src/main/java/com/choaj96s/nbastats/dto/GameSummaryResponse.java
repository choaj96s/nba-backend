package com.choaj96s.nbastats.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GameSummaryResponse {

    private String gameDate;

    private TeamSummary homeTeam;
    private TeamSummary visitorTeam;

    private List<KeyPlayer> homeTeamKeyPlayers;
    private List<KeyPlayer> visitorTeamKeyPlayers;

    private List<HighlightVideo> highlights;
}
