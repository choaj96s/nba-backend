package com.choaj96s.nbastats.service;

import com.choaj96s.nbastats.properties.SecretProperties;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.secretsmanager.SecretsManagerClient;
import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueRequest;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;

@Service
public class SecretService {

    private final SecretsManagerClient secretsManagerClient;
    private final SecretProperties secretProperties;

    public SecretService(SecretsManagerClient secretsManagerClient,
                         SecretProperties secretProperties) {
        this.secretsManagerClient = secretsManagerClient;
        this.secretProperties = secretProperties;
    }

    public String getBallDontLieSecret() {
        GetSecretValueRequest request = GetSecretValueRequest.builder()
                .secretId(secretProperties.getBalldontlieSecretName())
                .build();

        String secretJson = secretsManagerClient.getSecretValue(request).secretString();
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode node = objectMapper.readTree(secretJson);
            return node.get("BALDONTLIE_API_KEY").asText();
        } catch (Exception e) {
            throw new RuntimeException("Failed to parse secret JSON", e);
        }
    }

    public String getOpenAISecret() {
        GetSecretValueRequest request = GetSecretValueRequest.builder()
                .secretId(secretProperties.getOpenaiSecretName())
                .build();

        String secretJson = secretsManagerClient.getSecretValue(request).secretString();
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode node = objectMapper.readTree(secretJson);
            return node.get("OpenAI_API_KEY").asText();
        } catch (Exception e) {
            throw new RuntimeException("Failed to parse secret JSON", e);
        }
    }
}