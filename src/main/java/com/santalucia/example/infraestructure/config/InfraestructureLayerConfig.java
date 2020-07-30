package com.santalucia.example.infraestructure.config;

import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class InfraestructureLayerConfig {
	
	public InfraestructureLayerConfig() {
		log.debug("InfraestructureLayerConfig loaded");
	}
	
}