package com.example.configclient;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ConfigclientApplication {

	private final static Logger LOGGER = Logger.getLogger(ConfigclientApplication.class.getName());


	@RequestMapping("/instance")
	private String info(){
		LOGGER.debug("DEBUG MESSAGE");
		LOGGER.error("ERROR MESSAGE");
		LOGGER.info("INFO MESSAGE");
		return "null";
	}

	public static void main(String[] args) {
		SpringApplication.run(ConfigclientApplication.class, args);
	}
}
