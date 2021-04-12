package com.santalucia.example.core.service.impl;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Service;

import com.santalucia.arq.ams.componentes.errors.HttpErrorCodes;
import com.santalucia.arq.ams.componentes.exceptions.core.SantaluciaWebRuntimeException;
import com.santalucia.example.api.client.HelloWorldApiClient;
import com.santalucia.example.core.domain.IdentidadDigitalDomain;
import com.santalucia.example.core.errors.AppErrorCodes;
import com.santalucia.example.core.mappers.IdentidadDigitalDomainMapper;
import com.santalucia.example.core.service.HelloService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RemoteHelloService implements HelloService {

	private HelloWorldApiClient helloWorldApiClient;
	
	private IdentidadDigitalDomainMapper identidadDigitalMapper;
	
    @Autowired
    private MessageSourceAccessor messageSourceAccessor;

	public RemoteHelloService(HelloWorldApiClient helloWorldApiClient, IdentidadDigitalDomainMapper identidadDigitalMapper ) {
		log.info("Configured endpoint {}", helloWorldApiClient);
		this.helloWorldApiClient = helloWorldApiClient;
		this.identidadDigitalMapper = identidadDigitalMapper;
	}

	@Override
	public IdentidadDigitalDomain getHello(String name) {

		if ("TEST-USER".equalsIgnoreCase(name)) {
			throw new SantaluciaWebRuntimeException(AppErrorCodes.INVALID_NAME,HttpErrorCodes.HTTP_440,new RuntimeException("hola"));
		}

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