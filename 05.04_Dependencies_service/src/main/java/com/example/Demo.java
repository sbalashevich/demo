package com.example;

import com.example.db.PersonBO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
//@EnableEurekaClient
public class Demo {

    public static void main(String[] args) {
        SpringApplication.run(Demo.class, args);
    }

    @RequestMapping("/name")
    public PersonBO getData(){
        PersonBO person = new PersonBO();
        person.setName("Alex");
        person.setAddress("1 Infinite Loop");
        return person;
    }

}
