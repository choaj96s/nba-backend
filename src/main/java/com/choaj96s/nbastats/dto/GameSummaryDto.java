package com.choaj96s.nbastats.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class GameSummaryDto {

    @JsonProperty("home_team_summary")
    private TeamSummaryDto homeTeamSummary;

    @JsonProperty("visitor_team_summary")
    private TeamSummaryDto visitorTeamSummary;

    @JsonProperty("home_team_key_players")
    private List<KeyPlayerDto> homeTeamKeyPlayers;

    @JsonProperty("visitor_team_key_players")
    private List<KeyPlayerDto> visitorTeamKeyPlayers;

    public GameSummaryDto() {
    }

    public GameSummaryDto(TeamSummaryDto homeTeamSummary, TeamSummaryDto visitorTeamSummary,
                          List<KeyPlayerDto> homeTeamKeyPlayers, List<KeyPlayerDto> visitorTeamKeyPlayers) {
        this.homeTeamSummary = homeTeamSummary;
        this.visitorTeamSummary = visitorTeamSummary;
        this.homeTeamKeyPlayers = homeTeamKeyPlayers;
        this.visitorTeamKeyPlayers = visitorTeamKeyPlayers;
    }

    public TeamSummaryDto getHomeTeamSummary() {
        return homeTeamSummary;
    }

    public void setHomeTeamSummary(TeamSummaryDto homeTeamSummary) {
        this.homeTeamSummary = homeTeamSummary;
    }

    public TeamSummaryDto getVisitorTeamSummary() {
        return visitorTeamSummary;
    }

    public void setVisitorTeamSummary(TeamSummaryDto visitorTeamSummary) {
        this.visitorTeamSummary = visitorTeamSummary;
    }

    public List<KeyPlayerDto> getHomeTeamKeyPlayers() {
        return homeTeamKeyPlayers;
    }

    public void setHomeTeamKeyPlayers(List<KeyPlayerDto> homeTeamKeyPlayers) {
        this.homeTeamKeyPlayers = homeTeamKeyPlayers;
    }

    public List<KeyPlayerDto> getVisitorTeamKeyPlayers() {
        return visitorTeamKeyPlayers;
    }

    public void setVisitorTeamKeyPlayers(List<KeyPlayerDto> visitorTeamKeyPlayers) {
        this.visitorTeamKeyPlayers = visitorTeamKeyPlayers;
    }
}
