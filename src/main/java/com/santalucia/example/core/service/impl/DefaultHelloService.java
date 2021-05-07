package com.santalucia.example.core.service.impl;

import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.santalucia.example.api.client.HelloWorldApiClient;
import com.santalucia.example.api.model.IdentidadDigitalConsultaResource;
import com.santalucia.example.core.domain.IdentidadDigitalDomain;
import com.santalucia.example.core.domain.IdentidadDigitalDomain.IdentidadDigitalDomainBuilder;
import com.santalucia.example.core.exceptions.InvalidNameException;
import com.santalucia.example.core.mappers.IdentidadDigitalDomainMapper;
import com.santalucia.example.core.service.HelloService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultHelloService implements HelloService {

	private HelloWorldApiClient helloWorldApiClient;
	
	private IdentidadDigitalDomainMapper identidadDigitalMapper;
	
    private MessageSourceAccessor messageSourceAccessor;

	/**
	 * Constructor de clase 
	 * @param HelloWorldApiClient helloWorldApiClient
	 * @param IdentidadDigitalDomainMapper identidadDigitalMapper, 
	 * @param MessageSourceAccessor messageSourceAccessor
	 */
	public DefaultHelloService(HelloWorldApiClient helloWorldApiClient, IdentidadDigitalDomainMapper identidadDigitalMapper, MessageSourceAccessor messageSourceAccessor) {
		log.info("Configured endpoint {}", helloWorldApiClient);
		this.helloWorldApiClient = helloWorldApiClient;
		this.identidadDigitalMapper = identidadDigitalMapper;
		this.messageSourceAccessor = messageSourceAccessor;
	}

	/**
	 * servicio getHello
	 * @param String name
	 * @return IdentidadDigitalDomain
	 */
	@Override
	public IdentidadDigitalDomain getHelloRemoteByName(String name) {
		//Test de ejemplo para demostrar el uso de named exception strategy
		if ("test".equals(name)) {
			throw new InvalidNameException();
		}		

		// Ejemplo de llamada a remota
		ResponseEntity<IdentidadDigitalConsultaResource> response = helloWorldApiClient.getHelloByName(name, null);
		return this.identidadDigitalMapper.toDomain(response.getBody());
	}

	/**
	 * getHelloByName
	 * @param name
	 * @return String
	 */
	@Override
	public IdentidadDigitalDomain getHelloByName(String name) {
		IdentidadDigitalDomainBuilder identidad = IdentidadDigitalDomain.builder();
		identidad.nombre(name);
		identidad.saludo(String.format("Hello %s", name));
		return identidad.build();
	}
}