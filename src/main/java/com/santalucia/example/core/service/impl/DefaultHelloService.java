package com.santalucia.example.core.service.impl;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.santalucia.arq.ams.odl.recibos.api.client.RecibosApiClient;
import com.santalucia.arq.ams.odl.recibos.api.model.ReciboDetailResource;
import com.santalucia.example.api.client.HelloWorldApiClient;
import com.santalucia.example.api.model.IdentidadDigitalConsultaResource;
import com.santalucia.example.core.domain.IdentidadDigitalDomain;
import com.santalucia.example.core.domain.IdentidadDigitalDomain.IdentidadDigitalDomainBuilder;
import com.santalucia.example.core.exceptions.InvalidNameException;
import com.santalucia.example.core.mappers.IdentidadDigitalDomainMapper;
import com.santalucia.example.core.service.HelloService;

import feign.Feign;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultHelloService implements HelloService {

	private HelloWorldApiClient helloWorldApiClient;
	private RecibosApiClient recibosApiClient;

	private IdentidadDigitalDomainMapper identidadDigitalMapper;

	/**
	 * Constructor de clase
	 * @param HelloWorldApiClient helloWorldApiClient
	 * @param IdentidadDigitalDomainMapper identidadDigitalMapper,
	 * @param MessageSourceAccessor messageSourceAccessor
	 */
	public DefaultHelloService(RecibosApiClient recibosApiClient, HelloWorldApiClient helloWorldApiClient, IdentidadDigitalDomainMapper identidadDigitalMapper) {
		log.info("Configured endpoint {}", helloWorldApiClient);
		this.recibosApiClient = recibosApiClient;
		this.helloWorldApiClient = helloWorldApiClient;
		this.identidadDigitalMapper = identidadDigitalMapper;
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
		
		
		//Feign.builder().decode404()
		//"6255476e4e79ad10b078f220"
		
		/*
		ResponseEntity<ReciboDetailResource> recibo = 
				recibosApiClient.findByIdRecibosEntityUsingGET(
				"9995476e4e79ad10b078f220", 
				UUID.randomUUID());
		*/
		
		
		return IdentidadDigitalDomain.builder()
		.nombre(name)
		.saludo(String.format("Hello %s", name))
		.build();
	}
}
