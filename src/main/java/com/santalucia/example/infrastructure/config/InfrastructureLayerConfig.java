package com.santalucia.example.infrastructure.config;

import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class InfrastructureLayerConfig {

    /**
     * Constructor de clase
     */
	public InfrastructureLayerConfig() {
		log.debug("InfrastructureLayerConfig loaded");
	}

}