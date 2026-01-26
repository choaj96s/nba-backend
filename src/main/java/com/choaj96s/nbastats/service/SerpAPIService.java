package com.choaj96s.nbastats.service;

import com.choaj96s.nbastats.dto.SerpApiResponse;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class SerpAPIService {
    private final SecretService secretService;
    private final WebClient SerpAPIWebClient;

    public SerpAPIService(SecretService secretService, @Qualifier("serpApi") WebClient serpAPIWebClient) {
        this.secretService = secretService;
        this.SerpAPIWebClient = serpAPIWebClient;
    }

    public Mono<SerpApiResponse> searchGame(String query) {
        String serpApiKey = secretService.getSerpAPISecret();

        return SerpAPIWebClient.get()
                .uri(uriBuilder -> uriBuilder
                        .scheme("https")
                        .host("serpapi.com")
                        .path("/search.json")
                        .queryParam("engine", "google")
                        .queryParam("q", query)
                        .queryParam("api_key", serpApiKey)
                        .build())
                .retrieve()
                .bodyToMono(SerpApiResponse.class);
    }

}
