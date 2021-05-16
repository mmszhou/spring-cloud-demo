package com.yj.mms.service;


import com.yj.mms.api.TestDubboService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.ApplicationListener;

@Service
public class TestDubboServiceImpl implements TestDubboService, ApplicationListener<WebServerInitializedEvent> {

    private WebServerInitializedEvent event;

    @Override
    public String testDubbo() {
        return "hi~ dubbo success  " + event.getWebServer().getPort();
    }

    @Override
    public void onApplicationEvent(WebServerInitializedEvent webServerInitializedEvent) {
        event = webServerInitializedEvent;
    }
}
