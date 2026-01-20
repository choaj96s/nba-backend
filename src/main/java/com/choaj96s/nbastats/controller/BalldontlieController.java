package com.choaj96s.nbastats.controller;

import com.choaj96s.nbastats.service.BalldontlieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
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
}
