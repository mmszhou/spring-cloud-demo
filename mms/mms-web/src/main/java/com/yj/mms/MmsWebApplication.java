package com.yj.mms;

import com.yj.mms.model.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@SpringBootApplication
@EnableRedisHttpSession
@EnableDiscoveryClient
@ComponentScan(basePackages = "com.yj")
public class MmsWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(MmsWebApplication.class, args);
    }

    @Bean
    public RedisTemplate<String, Person> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Person> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        return template;
    }



}
