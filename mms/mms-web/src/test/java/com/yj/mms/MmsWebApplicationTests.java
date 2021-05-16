package com.yj.mms;


import com.yj.mms.service.TestService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MmsWebApplicationTests {

    @Autowired
    private TestService testService;

    @Test
    void contextLoads() {
        System.out.println(testService.testRedis());
    }

    @Test
    void testPerson(){
        System.out.println(testService.testRedisTemp());
    }
}
