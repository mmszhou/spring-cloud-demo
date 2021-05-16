package com.yj.mms.service;

import com.yj.mms.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate<String,Person> redisTemplate;

    public String testRedis(){
        stringRedisTemplate.opsForValue().set("test","redis : hello world");
        return stringRedisTemplate.opsForValue().get("test");
    }

    public Person testRedisTemp(){
        Person p = new Person();
        p.setId(1);
        p.setName("sb");
        redisTemplate.opsForValue().set("person",p);
        return  redisTemplate.opsForValue().get("person");
    }
}
