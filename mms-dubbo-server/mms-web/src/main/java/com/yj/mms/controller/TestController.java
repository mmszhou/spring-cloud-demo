package com.yj.mms.controller;

import com.yj.mms.service.TestDubboServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    /**
     * 发现 这实现类使用的是dubbo的service,这里也能够注入
     */
    @Autowired
    private TestDubboServiceImpl testDubboService;

    @GetMapping("testDubbo")
    private String testDubbo(){
        return testDubboService.testDubbo();
    }
}
