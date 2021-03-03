package com.santalucia.example.api.config;

import java.util.Optional;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import lombok.extern.slf4j.Slf4j;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.boot.starter.autoconfigure.SpringfoxConfigurationProperties;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Slf4j
@Configuration
@Import(BeanValidatorPluginsConfiguration.class)
@ConditionalOnWebApplication
@ConditionalOnProperty(value = "springfox.documentation.enabled", havingValue = "true")
@EnableConfigurationProperties(SpringfoxConfigurationProperties.class)
public class SpringFoxAmsConfig {

	private static final String DEFAULT_SPRINGFOX_UI = "/swagger-ui/index.html";

	public SpringFoxAmsConfig(SpringfoxConfigurationProperties prop) {
		log.info("Springfox is enabled: true");

		if (prop.getSwaggerUi() != null && prop.getSwaggerUi().getBaseUrl() != null) {
			log.info("Springfox ui published at: {}", prop.getSwaggerUi().getBaseUrl() + DEFAULT_SPRINGFOX_UI);
		} else {
			log.info("Springfox ui published at: {}", DEFAULT_SPRINGFOX_UI);
		}
	}

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any()).build()
				.directModelSubstitute(java.time.LocalDate.class, java.sql.Date.class)
				.directModelSubstitute(java.time.OffsetDateTime.class, java.util.Date.class)
				.genericModelSubstitutes(Optional.class);
	}

}
