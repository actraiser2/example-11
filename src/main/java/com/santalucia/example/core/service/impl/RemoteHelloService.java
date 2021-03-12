package com.santalucia.example.core.service.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.santalucia.example.api.client.HelloWorldApiClient;
import com.santalucia.example.core.domain.IdentidadDigitalDomain;
import com.santalucia.example.core.service.HelloService;
import com.santalucia.example.core.mappers.IdentidadDigitalDomainMapper;
import com.santalucia.example.api.model.IdentidadDigitalConsultaResource;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RemoteHelloService implements HelloService {

	private HelloWorldApiClient helloWorldApiClient;
	
	private IdentidadDigitalDomainMapper identidadDigitalMapper;

	public RemoteHelloService(HelloWorldApiClient helloWorldApiClient, IdentidadDigitalDomainMapper identidadDigitalMapper ) {
		log.info("Configured endpoint {}", helloWorldApiClient);
		this.helloWorldApiClient = helloWorldApiClient;
		this.identidadDigitalMapper = identidadDigitalMapper;
	}

	@Override
	public IdentidadDigitalDomain getHello(String name) {

		ResponseEntity<IdentidadDigitalConsultaResource> response = helloWorldApiClient.getHelloByName(name, null);
		
		return identidadDigitalMapper.toDomain(response.getBody());
	}

}