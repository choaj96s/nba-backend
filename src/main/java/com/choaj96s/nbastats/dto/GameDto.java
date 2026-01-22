package com.choaj96s.nbastats.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GameDto {
    private Integer id;
    private String date;
    private Integer season;
    private String status;
    private Integer period;
    private String time;
    private Boolean postseason;
    private String datetime;

    @JsonProperty("home_team_score")
    private Integer homeTeamScore;

    @JsonProperty("visitor_team_score")
    private Integer visitorTeamScore;

    @JsonProperty("home_team")
    private TeamDto homeTeam;

    @JsonProperty("visitor_team")
    private TeamDto visitorTeam;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getSeason() {
        return season;
    }

    public void setSeason(Integer season) {
        this.season = season;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Boolean getPostseason() {
        return postseason;
    }

    public void setPostseason(Boolean postseason) {
        this.postseason = postseason;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public Integer getHomeTeamScore() {
        return homeTeamScore;
    }

    public void setHomeTeamScore(Integer homeTeamScore) {
        this.homeTeamScore = homeTeamScore;
    }

    public Integer getVisitorTeamScore() {
        return visitorTeamScore;
    }

    public void setVisitorTeamScore(Integer visitorTeamScore) {
        this.visitorTeamScore = visitorTeamScore;
    }

    public TeamDto getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(TeamDto homeTeam) {
        this.homeTeam = homeTeam;
    }

    public TeamDto getVisitorTeam() {
        return visitorTeam;
    }

    public void setVisitorTeam(TeamDto visitorTeam) {
        this.visitorTeam = visitorTeam;
    }
}
