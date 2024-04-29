package com.santalucia.example.core.service;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.santalucia.example.api.client.HelloWorldApiClient;
import com.santalucia.example.api.model.IdentidadDigitalConsultaResource;
import com.santalucia.example.core.domain.IdentidadDigitalDomain;
import com.santalucia.example.core.exceptions.InvalidNameException;
import com.santalucia.example.core.mappers.IdentidadDigitalDomainMapper;

import lombok.AllArgsConstructor;


/**
 * DefaultHelloService
 *
 */
@Service
@AllArgsConstructor
public class DefaultHelloService implements HelloService {

	private HelloWorldApiClient helloWorldApiClient;
	private IdentidadDigitalDomainMapper identidadDigitalMapper;

	/**
	 * servicio getHello
	 * @param String name
	 * @return IdentidadDigitalDomain
	 */
	@Override
	public Optional<IdentidadDigitalDomain> getHelloRemoteByName(String name) {
		// Test de ejemplo para demostrar el uso de named exception strategy
		if ("test".equals(name)) {
			throw new InvalidNameException();
		}

		// Ejemplo de llamada a remota
		CompletableFuture<ResponseEntity<IdentidadDigitalConsultaResource>> completableFuture = helloWorldApiClient
				.getHelloByName(name, Optional.empty());

		ResponseEntity<IdentidadDigitalConsultaResource> identidadDigitalConsultaResource = completableFuture.join();

		return Optional.ofNullable(identidadDigitalConsultaResource.getBody())
				.map(v -> this.identidadDigitalMapper.toDomain(v));
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
