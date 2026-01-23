package com.choaj96s.nbastats.config;

import com.choaj96s.nbastats.service.SecretService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class OpenAiConfig {

    @Bean
    public WebClient openAiWebClient(WebClient.Builder builder,
                                     SecretService secretService) {

        String apiKey = secretService.getOpenAISecret();

        return builder
                .baseUrl("https://api.openai.com/v1")
                .defaultHeader(HttpHeaders.AUTHORIZATION, "Bearer " + apiKey)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }
}
