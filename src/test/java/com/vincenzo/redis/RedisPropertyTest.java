package com.vincenzo.redis;

import com.vincenzo.redis.config.RedisProperty;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class RedisPropertyTest {

    @Autowired
    RedisProperty redisProperty;

    @Test
    public void test() {
        String host = redisProperty.getHost();
        int port = redisProperty.getPort();

        assertEquals(host, "localhost");
        assertEquals(port, 6379);
    }
}
