package com.vincenzo.redis.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/v1/vincenzo/redis")
@RestController
public class RedisController {
    @Autowired
    private RedisTemplate redisTemplateWithString;

    @GetMapping("/hello")
    public String getHello() {
        log.info("- redis::hello");
        redisTemplateWithString.opsForValue().set("test", "hello");
        return redisTemplateWithString.opsForValue().get("test").toString();
    }

    @GetMapping("/integer")
    public Long getAutoIncrement() {
        return redisTemplateWithString.opsForValue().increment("my-integer");
    }
}
