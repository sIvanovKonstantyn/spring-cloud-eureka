package com.home.demos;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "spring-cloud-eureka-client1")
public interface EurekaClient1ApplicationClient {
    @RequestMapping("/greeting")
    String greeting();
}
