package com.santalucia.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;

import ch.qos.logback.access.tomcat.LogbackValve;

@SpringBootApplication
public class Application {

    /**
     * carga del aplicativo
     * @param String[] args
     */
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
