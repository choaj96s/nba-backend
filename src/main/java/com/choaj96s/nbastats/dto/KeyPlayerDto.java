package com.choaj96s.nbastats.dto;

public class KeyPlayerDto {

    private String name;
    private String performance;

    public KeyPlayerDto() {
    }

    public KeyPlayerDto(String name, String performance) {
        this.name = name;
        this.performance = performance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPerformance() {
        return performance;
    }

    public void setPerformance(String performance) {
        this.performance = performance;
    }
}
