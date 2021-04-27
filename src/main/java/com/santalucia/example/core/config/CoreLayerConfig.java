package com.santalucia.example.core.config;

import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class CoreLayerConfig {

    /**
     * constructor de clase
     * 
     */
	public CoreLayerConfig() {
		log.debug("CoreLayerConfig loaded");
	}

}