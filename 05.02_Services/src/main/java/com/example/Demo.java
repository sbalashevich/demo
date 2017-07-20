package com.example;

import com.example.db.PersonBO;
import com.example.db.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.app.ApplicationInstanceInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@SpringBootApplication
@RestController
public class Demo {

    @Autowired(required = false)
    private ApplicationInstanceInfo info;

    @Autowired
    private PersonRepository repo;

    public static void main(String[] args) {
        SpringApplication.run(Demo.class, args);
    }

    @GetMapping("/msg")
    String getMsg(){
        return "Hello World";
    }

    @GetMapping("/id")
    String getInstanceId(){
        if(info == null){
            return "Not a cloud environment";
        }else{
            return "Instance id: " + info.getInstanceId();
        }
    }

    @RequestMapping("/setname/{name}")
    private String setMsg(@PathVariable String name){
        PersonBO bo = new PersonBO();
        bo.setName(name);
        repo.save(bo);
        return "new instance created. name: " + name;
    }

    @RequestMapping("/getnames")
    private Iterable<PersonBO> getNames(){
        return repo.findAll();
    }
    @RequestMapping("/getenv")
    private  Map<String, String> getEnv(){
        Map<String, String> env = System.getenv();
        return env;
    }


// Scale

    @GetMapping("cpu/{timeout}")
    String cpuIntensiveTask(@PathVariable Long timeout){
        Long currentTime = System.currentTimeMillis();
        Long delta;
        do{
            fibonacci(40);
            delta = System.currentTimeMillis() - currentTime;
        }while(delta < timeout);

        return "done";
    }


    public static int fibonacci(int number){
        if(number == 1 || number == 2){
            return 1;
        }
        return fibonacci(number-1) + fibonacci(number -2);
    }



}
