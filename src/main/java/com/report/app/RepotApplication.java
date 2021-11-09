package com.report.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class RepotApplication {

	public static void main(String[] args) {
		SpringApplication.run(RepotApplication.class, args);
	}

}
