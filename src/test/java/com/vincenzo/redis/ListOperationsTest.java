package com.vincenzo.redis;

import com.vincenzo.redis.config.EmbeddedRedisConfig;
import com.vincenzo.redis.config.RedisConfig;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.redis.DataRedisTest;
import org.springframework.context.annotation.Import;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Import({EmbeddedRedisConfig.class, RedisConfig.class})
@DataRedisTest
public class ListOperationsTest {

    @Autowired StringRedisTemplate stringRedisTemplate;
    @Autowired RedisTemplate<String, String> myStringRedisTemplate;

    private final String REDIS_LPUSH_KEY = "lpush::";
    private final String REDIS_LPUSH_VALUE = "lpush::hello";
    private final String REDIS_RPUSH_KEY = "rpush::";
    private final String REDIS_RPUSH_VALUE = "rpush::hello";

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    public void listOperationTest_lpush_lpop(int count) {
        // opsForList()는 List를 Serialize, Deserialize 해 주는 interface이다.
        ListOperations<String, String> valueOperations =  stringRedisTemplate.opsForList();

        String expected = REDIS_LPUSH_VALUE + count;
        valueOperations.leftPush(REDIS_LPUSH_KEY, expected);

        String actual = valueOperations.leftPop(REDIS_LPUSH_KEY);
        System.out.println("actual:"+actual+", expected:" + expected);
        assertEquals(actual, expected);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    public void listOperationTest_rpush_rpop(int count) {
        // opsForList()는 List를 Serialize, Deserialize 해 주는 interface이다.
        ListOperations<String, String> valueOperations =  stringRedisTemplate.opsForList();

        String expected = REDIS_RPUSH_VALUE + count;
        valueOperations.rightPush(REDIS_RPUSH_KEY, expected);

        String actual = valueOperations.rightPop(REDIS_RPUSH_KEY);
        System.out.println("actual:"+actual+", expected:" + expected);
        assertEquals(actual, expected);
    }

}
