package com.choaj96s.nbastats.dto;

public class TeamSummaryDto {

    private String team;
    private String result;
    private String summary;

    public TeamSummaryDto() {
    }

    public TeamSummaryDto(String team, String result, String summary) {
        this.team = team;
        this.result = result;
        this.summary = summary;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
