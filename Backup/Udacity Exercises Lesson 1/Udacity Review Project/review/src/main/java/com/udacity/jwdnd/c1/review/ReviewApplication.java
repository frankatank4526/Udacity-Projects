package com.udacity.jwdnd.c1.review;

import org.apache.logging.log4j.message.Message;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
public class ReviewApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReviewApplication.class, args);
	}
	/*
@Bean
	public String message(){
		System.out.println("Message Created!");
		return "Hello Spring!";
}
@Bean
	public String upperCaseMessage(MessageService messageService){
		System.out.println("UpperCase Message Created!");
		return messageService.uppercase();
	}
@Bean
	public String lowerCaseMessage(MessageService messageService){
		System.out.println("LowerCase Message Created!");
		return messageService.lowercase();
	}
*/
}
