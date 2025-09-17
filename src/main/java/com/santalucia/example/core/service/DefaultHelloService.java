package com.santalucia.example.core.service;

import java.util.Optional;

import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Service;

import com.santalucia.example.api.model.IdentidadDigitalConsultaResource;
import com.santalucia.example.core.domain.IdentidadDigitalDomain;
import com.santalucia.example.core.exceptions.InvalidNameException;
import com.santalucia.example.core.mappers.IdentidadDigitalDomainMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


/**
 * DefaultHelloService
 *
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class DefaultHelloService implements HelloService {
	
	private final MessageSourceAccessor messageSourceAccessor;


	private final IdentidadDigitalDomainMapper identidadDigitalMapper;

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

		IdentidadDigitalConsultaResource resource = new IdentidadDigitalConsultaResource();

		return Optional.ofNullable(resource)
				.map(v -> this.identidadDigitalMapper.toDomain(v));
	}

	/**
	 * getHelloByName
	 * @param name
	 * @return String
	 */

	@Override
	public IdentidadDigitalDomain getHelloByName(String name) {
		log.error("entro por el async!!!!!!!");
		return IdentidadDigitalDomain.builder()
		.nombre(name)
		.saludo(messageSourceAccessor.getMessage("label.error.407", new String[] {name}))
		.build();
	}
}
