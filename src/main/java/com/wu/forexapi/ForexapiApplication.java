package com.wu.forexapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ForexapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ForexapiApplication.class, args);
	}
}
