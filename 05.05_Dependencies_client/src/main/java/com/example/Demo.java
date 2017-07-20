package com.example;

import com.example.db.PersonBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
//@EnableEurekaClient
public class Demo {


    public static void main(String[] args) {
        SpringApplication.run(Demo.class, args);
    }


    @Value(value = "${server.url}")
    private String serverUrl;

    @RequestMapping("greetings")
    private String hello(){
        RestTemplate template = new RestTemplate();
        PersonBO response = template.getForObject(serverUrl, PersonBO.class);

        return "Hello " + response.getName();
    }


//    @Autowired
//    private RestTemplate restTemplate;
//    @RequestMapping("greetings2")
//    private String hello2(){
//        return "Hello " + restTemplate.getForObject(serverUrl, PersonBO.class).getName();
//    }
//


}
