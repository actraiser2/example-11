package com.santalucia.example;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import lombok.Generated;

/**
 * Application
 * Hay que incluir @Generated para evitar que compute en cobertura
 */
@Generated
@SpringBootApplication
public class Application {

    /**
     * Carga del aplicativo
     *
     * @param String[] args
     */
    public static void main(String[] args) {
        new SpringApplicationBuilder(Application.class)
                //.applicationStartup(new BufferingApplicationStartup(ByteSizeConstants.TWO_KB.intValue()))
                .run(args);
    }
}
