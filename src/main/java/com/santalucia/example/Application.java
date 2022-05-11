package com.santalucia.example;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.metrics.buffering.BufferingApplicationStartup;


@SpringBootApplication
public class Application {

	private static final int STARTUP_LOG_BUFFER_SIZE = 2048;
    /**
     * carga del aplicativo
     *
     * @param String[] args
     */
    public static void main(String[] args) {
        new SpringApplicationBuilder(Application.class)
                .applicationStartup(new BufferingApplicationStartup(STARTUP_LOG_BUFFER_SIZE))
                .run(args);
    }
}
