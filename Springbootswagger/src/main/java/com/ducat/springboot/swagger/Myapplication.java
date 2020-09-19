package com.ducat.springboot.swagger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;


//This annotation enables the auto-configuration feature of the spring boot module (i.e. java-based configuration and component scanning)
@SpringBootApplication

//The main class serves two purpose in a spring boot application: Configuration and bootstrapping.
@ComponentScan(basePackages = {"com.allianz.sensorapp.util","com.ducat.springboot.swagger","com.ducat.springboot.swagger.service"})
@EntityScan("com.ducat.springboot.swagger.model")
public class Myapplication {

	public static void main(String[] args) {
		SpringApplication.run(Myapplication.class, args);
	}
}