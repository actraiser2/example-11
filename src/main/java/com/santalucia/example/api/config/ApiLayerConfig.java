package com.santalucia.example.api.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

/**
 * @author 05428576R
 *
 */
@Slf4j
@Configuration
public class ApiLayerConfig {

    /**
     * constructor de clase
     */
	public ApiLayerConfig() {
		log.debug("PresentationLayerConfig loaded");
	}

}
