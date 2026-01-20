package com.choaj96s.nbastats.controller;

import com.choaj96s.nbastats.service.SecretService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SecretController {
    private final SecretService secretService;

    public SecretController(SecretService secretService) {
        this.secretService = secretService;
    }

    @GetMapping("/secret")
    public String getSecret() {
        return secretService.getSecret();
    }
}
