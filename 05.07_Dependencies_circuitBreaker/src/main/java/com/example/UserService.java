package com.example;

import com.example.db.PersonBO;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
public class UserService {

    @Value(value = "${server.url}")
    private String serverUrl;

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "reliable")
    public String getName() {
        URI uri = URI.create(serverUrl);
        return restTemplate.getForObject(uri, PersonBO.class).getName();
    }

    public String reliable() {
        return "dear User";
    }

}
