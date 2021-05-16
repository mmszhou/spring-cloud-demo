package com.yj.mms.controller;

import com.yj.mms.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController implements ApplicationListener<WebServerInitializedEvent> {

    @Autowired
    private TestService testService;

    private  WebServerInitializedEvent event;


    @GetMapping("/testFeign")
    public String testFeign(){
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "hi Feign is success!" + event.getWebServer().getPort();
    }

    /**
     * 为了测试多实例，获取端口号
     * @param webServerInitializedEvent
     */
    @Override
    public void onApplicationEvent(WebServerInitializedEvent webServerInitializedEvent) {
        event = webServerInitializedEvent;
    }
}
