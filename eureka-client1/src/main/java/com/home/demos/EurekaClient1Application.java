package com.home.demos;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Random;

@SpringBootApplication
@RestController
@EnableDiscoveryClient
public class EurekaClient1Application {

    @Value("${spring.application.name}")
    private String appName;

    public static void main(String[] args) {
        SpringApplication.run(EurekaClient1Application.class, args);
    }

    @RequestMapping("/greeting")
    public String greeting() {

        if (new Random().nextBoolean()) {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(LocalDateTime.now() + ": was delay!!!");
            return "Hello from main service with delay";
        }
        return String.format(
                "Hello from '%s'!", EurekaClient1Application.class.getName()
        );
    }
}
