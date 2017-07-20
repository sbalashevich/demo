package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.app.ApplicationInstanceInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@SpringBootApplication
@RestController
public class Demo {

    @Autowired(required = false)
    private ApplicationInstanceInfo info;
    private String KEY = "session.key";

    public static void main(String[] args) {
        SpringApplication.run(Demo.class, args);
    }

    @GetMapping("/id")
    String getInstanceId(){
        if(info == null){
            return "Not a cloud environment";
        }else{
            return "Instance id: " + info.getInstanceId();
        }
    }
    // Session
    @RequestMapping("/setvalue/{name}")
    private String setMsg(HttpServletRequest request, @PathVariable String name){
        request.getSession().setAttribute(KEY, name);
        return "new Value set to: " + name;
    }


    @RequestMapping("/value")
    private String name(HttpServletRequest request){
        String insanceID = info != null ? info.getInstanceId() : "not available";
        return "Value: " + (String)request.getSession().getAttribute(KEY) + "; instance: " + insanceID ;
    }


}
