package com.santalucia.example.core.service.impl;

import java.util.Optional;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import com.santalucia.example.api.client.HelloWorldApiClient;
import com.santalucia.example.core.domain.IdentidadDigitalDomain;
import com.santalucia.example.core.exceptions.InvalidNameException;
import com.santalucia.example.core.mappers.IdentidadDigitalDomainMapper;
import com.santalucia.example.core.service.HelloService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultHelloService implements HelloService {

	private HelloWorldApiClient helloWorldApiClient;

	private IdentidadDigitalDomainMapper identidadDigitalMapper;

	/**
	 * Constructor de clase
	 * @param HelloWorldApiClient helloWorldApiClient
	 * @param IdentidadDigitalDomainMapper identidadDigitalMapper,
	 * @param MessageSourceAccessor messageSourceAccessor
	 */
	public DefaultHelloService(/**RecibosApiClient recibosApiClient,**/ HelloWorldApiClient helloWorldApiClient, IdentidadDigitalDomainMapper identidadDigitalMapper) {
		log.info("Configured endpoint {}", helloWorldApiClient);
		this.helloWorldApiClient = helloWorldApiClient;
		this.identidadDigitalMapper = identidadDigitalMapper;
	}

	/**
	 * servicio getHello
	 * @param String name
	 * @return IdentidadDigitalDomain
	 */
	@Override
	@Nullable
	public IdentidadDigitalDomain getHelloRemoteByName(String name) {
		//Test de ejemplo para demostrar el uso de named exception strategy
		if ("test".equals(name)) {
			throw new InvalidNameException();
		}

		// Ejemplo de llamada a remota
		return Optional.ofNullable(helloWorldApiClient.getHelloByName(name, null).getBody())
		.map(v -> this.identidadDigitalMapper.toDomain(v))
		.orElse(null);
	}

	/**
	 * getHelloByName
	 * @param name
	 * @return String
	 */
	@Override
	public IdentidadDigitalDomain getHelloByName(String name) {
		
		
		return IdentidadDigitalDomain.builder()
		.nombre(name)
		.saludo(String.format("Hello %s", name))
		.build();
	}
}
