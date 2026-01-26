package com.choaj96s.nbastats.config;

import com.choaj96s.nbastats.service.SecretService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
@Configuration
public class SerpAPIConfig {

    @Bean
    @Qualifier("serpApi")
    public WebClient SerpAPIWebClient(WebClient.Builder builder) {

        return builder
                .baseUrl("https://serpapi.com/")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }
}
