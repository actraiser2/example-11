package com.santalucia.example.core.config;

import java.util.function.Supplier;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.santalucia.arq.ams.api.config.ClientConfiguration;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;


/**
 * CoreLayerConfig
 *
 */
@Slf4j
@Configuration(proxyBeanMethods = false)
public class CoreLayerConfig {

    /**
     * constructor de clase
     *
     */
	public CoreLayerConfig() {
		log.debug("CoreLayerConfig loaded");

	}
	
	
	

}
