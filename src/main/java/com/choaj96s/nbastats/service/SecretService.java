package com.choaj96s.nbastats.service;

import com.choaj96s.nbastats.properties.SecretProperties;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.secretsmanager.SecretsManagerClient;
import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueRequest;

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

        return secretsManagerClient.getSecretValue(request).secretString();
    }
}