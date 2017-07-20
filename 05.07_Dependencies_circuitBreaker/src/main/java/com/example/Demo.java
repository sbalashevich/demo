package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
//import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableEurekaClient
@EnableCircuitBreaker
//@EnableHystrixDashboard
public class Demo {


    public static void main(String[] args) {
        SpringApplication.run(Demo.class, args);
    }

    @Autowired
    private UserService userService;


    @RequestMapping("greetings")
    private String hello(){
        return "Hello " + userService.getName();
    }


}
