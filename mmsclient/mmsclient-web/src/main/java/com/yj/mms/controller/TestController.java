package com.yj.mms.controller;

import com.yj.mms.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @RequestMapping("test")
    public String test(){
        return testService.testService();
    }

    @RequestMapping("testFeign")
    public String testFeign(){
        return testService.testFeign();
    }
}
