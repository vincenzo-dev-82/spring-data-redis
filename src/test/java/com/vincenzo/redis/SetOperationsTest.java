package com.vincenzo.redis;

import com.vincenzo.redis.config.EmbeddedRedisConfig;
import com.vincenzo.redis.config.RedisConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.redis.DataRedisTest;
import org.springframework.context.annotation.Import;
import org.springframework.data.redis.core.*;

import java.util.Arrays;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Import({EmbeddedRedisConfig.class, RedisConfig.class})
@DataRedisTest
public class SetOperationsTest {

    @Autowired StringRedisTemplate stringRedisTemplate;
    @Autowired RedisTemplate<String, String> myStringRedisTemplate;

    private final String REDIS_SET_KEY = "set::";
    private final String REDIS_SET_VALUE = "set::hello";

    @Test
    public void setOperationTest() {
        // opsForSet()는 Set을 Serialize, Deserialize 해 주는 interface이다.
        SetOperations<String, String> setOperations =  stringRedisTemplate.opsForSet();

        setOperations.add(REDIS_SET_KEY, REDIS_SET_VALUE + 1);
        setOperations.add(REDIS_SET_KEY, REDIS_SET_VALUE + 2);
        setOperations.add(REDIS_SET_KEY, REDIS_SET_VALUE + 3);

        Set<String> setResults = setOperations.members(REDIS_SET_KEY);
        System.out.println("setResults:" + Arrays.toString(setResults.toArray()));
        final Long actualSize = setOperations.size(REDIS_SET_KEY);

        assertEquals(actualSize, 3);

        Cursor<String> cursor = setOperations.scan(REDIS_SET_KEY, ScanOptions.scanOptions().match("*").build());
        while(cursor.hasNext()) {
            System.out.println("cursor:" + cursor.next());
        }
    }
}
