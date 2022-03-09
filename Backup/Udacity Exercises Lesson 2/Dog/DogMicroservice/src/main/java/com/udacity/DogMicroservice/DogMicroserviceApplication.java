package com.udacity.DogMicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class DogMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DogMicroserviceApplication.class, args);
	}

}
