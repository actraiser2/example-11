package com.santalucia.example.api.config;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@ConditionalOnMissingBean(SpringFoxAmsConfig.class)
public class SpringFoxAmsDisabledConfig {

	public SpringFoxAmsDisabledConfig() {
		log.info("Springfox is enabled: false");
	}
	
}
