package com.vincenzo.redis;

import com.vincenzo.redis.config.EmbeddedRedisConfig;
import com.vincenzo.redis.config.RedisConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.redis.DataRedisTest;
import org.springframework.context.annotation.Import;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Import({EmbeddedRedisConfig.class, RedisConfig.class})
@DataRedisTest
public class ValueOperationsTest {

    @Autowired StringRedisTemplate stringRedisTemplate;
    @Autowired RedisTemplate<String, String> myStringRedisTemplate;

    private final String REDIS_TEST_KEY = "test::1";
    private final String REDIS_TEST_VALUE = "hello";

    @Test
    public void valueOperationsTest_1() {
        // opsForValue()는 String을 Serialize, Deserialize 해 주는 interface이다.
        ValueOperations<String, String> valueOperations =  stringRedisTemplate.opsForValue();

        valueOperations.set(REDIS_TEST_KEY, REDIS_TEST_VALUE);
        String realValue = valueOperations.get(REDIS_TEST_KEY).toString();

        assertEquals(REDIS_TEST_VALUE, realValue);
    }

    @Test
    public void valueOperationsTest_2() {
        // opsForValue()는 String을 Serialize, Deserialize 해 주는 interface이다.
        ValueOperations<String, String> valueOperations =  myStringRedisTemplate.opsForValue();

        valueOperations.set(REDIS_TEST_KEY, REDIS_TEST_VALUE);
        String realValue = valueOperations.get(REDIS_TEST_KEY).toString();

        assertEquals(REDIS_TEST_VALUE, realValue);
    }
}
