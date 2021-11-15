package com.vincenzo.redis.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.redis.DataRedisTest;
import org.springframework.context.annotation.Import;
import org.springframework.data.redis.core.RedisTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Import({EmbeddedRedisConfig.class, RedisConfig.class})
@DataRedisTest
public class RedisTemplateTest {

    @Autowired RedisTemplate<String, String> myStringRedisTemplate;

    private final String REDIS_TEST_KEY = "test::1";
    private final String REDIS_TEST_VALUE = "hello";

    @Test
    public void test() {
        myStringRedisTemplate.opsForValue().set(REDIS_TEST_KEY, REDIS_TEST_VALUE);
        String realValue = myStringRedisTemplate.opsForValue().get(REDIS_TEST_KEY).toString();
        assertEquals(REDIS_TEST_VALUE, realValue);
    }

}
