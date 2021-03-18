package com.santalucia.example.api.config;

import java.time.Duration;
import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.util.StringUtils;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import com.santalucia.arq.ams.componentes.web.errorhandling.RestAPIErrorHandler;

import lombok.extern.slf4j.Slf4j;

/**
 * @author 05428576R
 * 
 * Se copia el comportamiento de la clase MessageSourceAutoConfiguration
 * https://github.com/spring-projects/spring-boot/blob/master/spring-boot-project/spring-boot-autoconfigure/src/main/java/org/springframework/boot/autoconfigure/context/MessageSourceAutoConfiguration.java
 */

@Slf4j
@Configuration
public class ApiLayerConfig {
	
	private static final String MW_ERRORS_BASENAMES = "classpath:i18n/mw-errors";

	public ApiLayerConfig() {
		log.debug("PresentationLayerConfig loaded");
		
	}
	
	@Bean
	@Primary
	public RestAPIErrorHandler han(MessageSourceAccessor errorMessageUtils) {
		log.error("NACHOOOOOOOOOOOO");
		return new RestAPIErrorHandler(errorMessageUtils);
	}

	/*
	@Bean
	public AcceptHeaderLocaleResolver acceptlocaleResolver(CustomMessageSourceProperties properties) {

		AcceptHeaderLocaleResolver slr = new AcceptHeaderLocaleResolver();

		Locale defaultLocale = properties.getDefaultLocale();
		
		log.info("i18n default server locale: {}",Locale.getDefault());
		log.info("i18n app. requested locale: {}",defaultLocale);
		
	
		if (!Locale.getDefault().equals(defaultLocale)) {
			log.warn("Changing default server locale to {}",defaultLocale);
			slr.setDefaultLocale(defaultLocale);
			Locale.setDefault(defaultLocale);
		}

	    return slr;
	}
*/
	
	//Bean de soporte para la transformacion de mensajes sin definir Locale
	@Bean
	public MessageSourceAccessor getMessageSourceAccessor(final MessageSource messageSource) {
	    return new MessageSourceAccessor(messageSource);
	}

	//Bean de properties debido a dependencia circular
	@Bean
	public CustomMessageSourceProperties messageSourceProperties() {
		return new CustomMessageSourceProperties();
	}

	//Creacion del messageSource en base a un ReloadableResourceBundleMessageSource 
	//y añadimos de forma custom los errores de mw
	@Bean
	public MessageSource messageSource(CustomMessageSourceProperties properties) {
		log.trace("i18n properties: {}",properties);
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();

		messageSource.addBasenames(MW_ERRORS_BASENAMES);
		
		if (StringUtils.hasText(properties.getBasename())) {
			messageSource
				.addBasenames(
						StringUtils.commaDelimitedListToStringArray(
								StringUtils.trimAllWhitespace(properties.getBasename())));
		}
		
		log.debug("i18n configured with basenames: {}",messageSource.getBasenameSet());
		
		if (properties.getEncoding() != null) {
			messageSource.setDefaultEncoding(properties.getEncoding().name());
		}
		messageSource.setFallbackToSystemLocale(properties.isFallbackToSystemLocale());
		Duration cacheDuration = properties.getCacheDuration();
		if (cacheDuration != null) {
			messageSource.setCacheMillis(cacheDuration.toMillis());
		}
		messageSource.setAlwaysUseMessageFormat(properties.isAlwaysUseMessageFormat());
		messageSource.setUseCodeAsDefaultMessage(properties.isUseCodeAsDefaultMessage());
		return messageSource;
	}
	
	//seteamos la internacionalizacion de mensajes a los bean validators
	@Bean
	public LocalValidatorFactoryBean getValidator(MessageSource source) {
	    LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
	    bean.setValidationMessageSource(source);
	    return bean;
	}
	

}