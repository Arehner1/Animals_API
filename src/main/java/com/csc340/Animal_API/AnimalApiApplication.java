package com.csc340.Animal_API;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class AnimalApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnimalApiApplication.class, args);
	}
}
