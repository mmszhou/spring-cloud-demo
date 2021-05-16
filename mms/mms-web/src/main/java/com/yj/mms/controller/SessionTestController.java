package com.yj.mms.controller;

import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class SessionTestController {

    @RequestMapping("/getSession")
    public String getTestSession(HttpSession session,String myj){
        String name = (String)session.getAttribute(myj);
        if(name == null){
            session.setAttribute(myj,"love mms");
        }

        return "result" +  (String)session.getAttribute(myj);
    }
}
