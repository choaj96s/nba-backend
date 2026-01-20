package com.choaj96s.nbastats.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "aws")
public class SecretProperties {
    private String secretName;

    public String getSecretName() {
        return secretName;
    }

    public void setSecretName(String secretName) {
        this.secretName = secretName;
    }
}