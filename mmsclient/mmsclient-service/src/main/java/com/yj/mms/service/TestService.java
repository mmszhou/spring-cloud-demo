package com.yj.mms.service;

import com.yj.mms.TestFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    @Autowired
    private TestFeignService testFeignService;

    public String testService(){
        return "hello world!";
    }

    public String testFeign(){
       return  testFeignService.testFeign();
    }
}
