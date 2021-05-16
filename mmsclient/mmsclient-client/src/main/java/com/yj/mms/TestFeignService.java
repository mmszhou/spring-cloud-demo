package com.yj.mms;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "mms-server")
public interface TestFeignService {

    /**
     * 测试feign调用
     * @return
     */
    @GetMapping("/testFeign")
    String testFeign();
}
