package com.yj.mms;

import com.yj.mms.support.ClientConnectionKeepAliveStrategy;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class MmsclientWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(MmsclientWebApplication.class, args);
    }

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public CloseableHttpClient httpClient() {

        return HttpClients.custom()
                .setConnectionTimeToLive(30, TimeUnit.SECONDS)
                .evictIdleConnections(30, TimeUnit.SECONDS)
                .setMaxConnTotal(20)
                .setMaxConnPerRoute(20)
                .disableAutomaticRetries()//关闭重试
                .setKeepAliveStrategy(new ClientConnectionKeepAliveStrategy())
                .build();
    }

    @RestController
    public class TestController {

        private final RestTemplate restTemplate;

        @Autowired
        public TestController(RestTemplate restTemplate) {
            this.restTemplate = restTemplate;
        }

        @GetMapping("/testFeign8089")
        public String testFeign() {
            return restTemplate.getForObject("http://mms-server/testFeign", String.class);
        }
    }

}
