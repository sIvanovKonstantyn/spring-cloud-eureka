package com.home.demos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableDiscoveryClient
@EnableFeignClients
public class EurekaClient2Application {

    @Autowired
    private EurekaClient1ApplicationClient client1ApplicationClient;

    public static void main(String[] args) {
        SpringApplication.run(EurekaClient2Application.class, args);
    }

    @RequestMapping("/greeting")
    public String greeting() {
        return client1ApplicationClient.greeting();
    }
}
