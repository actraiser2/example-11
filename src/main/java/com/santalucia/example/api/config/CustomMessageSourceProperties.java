package com.santalucia.example.api.config;

import java.util.Locale;

import org.springframework.boot.autoconfigure.context.MessageSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ConfigurationProperties(prefix = "spring.messages")
public class CustomMessageSourceProperties extends MessageSourceProperties{
	
	/** Default Locale */
	//private String defaultLocale= "es_ES";
	
	/**
	 * Locale to use. By default, this locale is overridden by the "Accept-Language"
	 * header.
	 */
	private Locale defaultLocale;

}
