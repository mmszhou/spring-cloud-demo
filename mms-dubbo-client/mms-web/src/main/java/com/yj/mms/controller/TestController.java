package com.yj.mms.controller;

import com.yj.mms.api.TestDubboService;
import org.apache.dubbo.config.annotation.Reference;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Reference
    TestDubboService testDubboService;


    @GetMapping("/testDubbo")
    public String testDubbo(){
        return testDubboService.testDubbo();
    }
}
