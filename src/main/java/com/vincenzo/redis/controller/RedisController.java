package com.vincenzo.redis.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/v1/vincenzo/redis")
@RestController
public class RedisController {

    private ValueOperations<String, String> myStringRedisTemplate;

    public RedisController(RedisTemplate<String, String> myStringRedisTemplate) {
        this.myStringRedisTemplate = myStringRedisTemplate.opsForValue();
    }

    @GetMapping("/hello")
    public String getHello() {
        log.info("- redis::hello");
        myStringRedisTemplate.set("test", "hello");
        return myStringRedisTemplate.get("test").toString();
    }

    @GetMapping("/integer")
    public Long getAutoIncrement() {
        return myStringRedisTemplate.increment("my-integer");
    }
}
