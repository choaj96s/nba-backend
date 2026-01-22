package com.choaj96s.nbastats.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "aws")
public class SecretProperties {
    private String balldontlieSecretName;
    private String openaiSecretName;

    public String getBalldontlieSecretName() {
        return balldontlieSecretName;
    }

    public void setBalldontlieSecretName(String balldontlieSecretName) {
        this.balldontlieSecretName = balldontlieSecretName;
    }

    public String getOpenaiSecretName() {
        return openaiSecretName;
    }

    public void setOpenaiSecretName(String openaiSecretName) {
        this.openaiSecretName = openaiSecretName;
    }
}