package com.udacity.jdnd.course1exercises;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@ComponentScan
public class Course1ExercisesApplication {

	public static void main(String[] args) {
		SpringApplication.run(Course1ExercisesApplication.class, args);
	}

}
