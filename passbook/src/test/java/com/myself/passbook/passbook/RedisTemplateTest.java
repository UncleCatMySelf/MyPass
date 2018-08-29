package com.myself.passbook.passbook;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * @Author:UncleCatMySelf
 * @Email：zhupeijie_java@126.com
 * @QQ:1341933031
 * @Date:Created in 13:49 2018\8\28 0028
 */
public class RedisTemplateTest extends PassbookApplicationTests {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Test
    public void testRedisTemplate(){

        redisTemplate.execute((RedisCallback<Object>) connection ->{
            connection.flushAll();
            return null;
        });

        assert redisTemplate.opsForValue().get("name") == null;
        redisTemplate.opsForValue().set("name","passbook");
        assert redisTemplate.opsForValue().get("name") != null;

    }

}
