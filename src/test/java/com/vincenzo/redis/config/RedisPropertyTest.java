package com.vincenzo.redis.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class RedisPropertyTest {

    @Autowired
    RedisProperties redisProperties;

    @Test
    public void test() {
        String host = redisProperties.getHost();
        int port = redisProperties.getPort();

        assertEquals(host, "localhost");
        assertEquals(port, 6379);
    }
}
