package com.udacity.eurekaProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaProjectApplication.class, args);
	}

}
