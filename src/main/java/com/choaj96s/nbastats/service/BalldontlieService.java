package com.choaj96s.nbastats.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class BalldontlieService {

    private final WebClient webClient;
    private final SecretService secretService;

    public BalldontlieService(WebClient webClient, SecretService secretService) {
        this.webClient = webClient;
        this.secretService = secretService;
    }

    public String getTeams() {
        String apiKey = secretService.getSecret().trim();

        return webClient.get()
                .uri("/teams")
                .header("Authorization", apiKey)
                .retrieve()
                .bodyToMono(String.class)
                .block();   // 현재는 blocking 방식으로 간단히 처리
    }
}
