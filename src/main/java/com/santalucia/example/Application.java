package com.santalucia.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.santalucia.example")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
