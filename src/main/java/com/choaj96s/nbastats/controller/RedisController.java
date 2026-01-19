package com.choaj96s.nbastats.controller;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/redis")
public class RedisController {

    private final RedisTemplate<String, String> redisTemplate;

    public RedisController(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @GetMapping("/set")
    public String set() {
        redisTemplate.opsForValue().set("hello", "world");
        return "OK";
    }

    @GetMapping("/get")
    public String get() {
        return redisTemplate.opsForValue().get("hello");
    }
}

