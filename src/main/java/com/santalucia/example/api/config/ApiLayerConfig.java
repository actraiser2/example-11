package com.santalucia.example.api.config;

import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JSR310Module;

import lombok.extern.slf4j.Slf4j;

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
	
	@Bean
	@LoadBalanced()
	RestClient.Builder restClientBuilder() {
		return RestClient.builder();
	}

	@Bean
	RestClient restClient(RestClient.Builder builder) {
		return builder.baseUrl("http://example-app-11").build();
	}
	
	@Bean
	 Jackson2ObjectMapperBuilderCustomizer jsonCustomizer() {
	    return builder -> builder.modules(new Jdk8Module(), new JSR310Module());
	}

}
