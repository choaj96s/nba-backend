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

    public String getSecret() {
        GetSecretValueRequest request = GetSecretValueRequest.builder()
                .secretId(secretProperties.getSecretName())
                .build();

        String secretJson = secretsManagerClient.getSecretValue(request).secretString();
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode node = objectMapper.readTree(secretJson);
            return node.get("BALDONTLIE_API_KEY").asString();
        } catch (Exception e) {
            throw new RuntimeException("Failed to parse secret JSON", e);
        }
    }
}