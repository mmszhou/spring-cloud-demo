package com.yj.mms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MmsWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(MmsWebApplication.class, args);
    }

}
