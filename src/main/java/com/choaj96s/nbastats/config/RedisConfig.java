package com.choaj96s.nbastats.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class RedisConfig {

    @Bean
    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String, String> template = new RedisTemplate<>();
        template.setConnectionFactory(factory);
        return template;
    }

//    @Bean
//    public CommandLineRunner redisCheck(RedisConnectionFactory factory) {
//        return args -> {
//            System.out.println("Redis connection class: " + factory.getClass().getName());
//            System.out.println("Redis host: " + factory.getConnection().getClientName());
//        };
//    }
}
