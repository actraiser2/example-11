package com.santalucia.example.core.service.impl;

import java.util.Locale;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Service;

import com.santalucia.example.api.client.HelloWorldApiClient;
import com.santalucia.example.core.domain.IdentidadDigitalDomain;
import com.santalucia.example.core.mappers.IdentidadDigitalDomainMapper;
import com.santalucia.example.core.service.HelloService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RemoteHelloService implements HelloService {

	private HelloWorldApiClient helloWorldApiClient;
	
	private IdentidadDigitalDomainMapper identidadDigitalMapper;
	
    private MessageSourceAccessor messageSourceAccessor;

	public RemoteHelloService(HelloWorldApiClient helloWorldApiClient, IdentidadDigitalDomainMapper identidadDigitalMapper, MessageSourceAccessor messageSourceAccessor ) {
		log.info("Configured endpoint {}", helloWorldApiClient);
		this.helloWorldApiClient = helloWorldApiClient;
		this.identidadDigitalMapper = identidadDigitalMapper;
		this.messageSourceAccessor = messageSourceAccessor;
	}

	@Override
	public IdentidadDigitalDomain getHello(String name) {

		/*
		if ("TEST-USER".equalsIgnoreCase(name)) {
			throw new SantaluciaWebRuntimeException(AppErrorCodes.INVALID_NAME,new RuntimeException("hola"));
		}
		*/
		
		

		Locale locale = LocaleContextHolder.getLocale();
		// String nombre = languageUtil.getLocalizedMessage("label.error.407", "NACHO");

		String nombre = String.format("Request received. Language: %s, Country: %s %n", locale.getLanguage(),
				locale.getDisplayCountry());

		return IdentidadDigitalDomain.builder().nombre(nombre).build();

		// ResponseEntity<IdentidadDigitalConsultaResource> response =
		// helloWorldApiClient.getHelloByName(name, null);
		// return identidadDigitalMapper.toDomain(response.getBody());
	}

}