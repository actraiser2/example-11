package com.santalucia.example.core.service.impl;

import org.springframework.stereotype.Service;

import com.santalucia.example.api.client.HelloWorldApiClient;
import com.santalucia.example.core.domain.IdentidadDigitalDomain;
import com.santalucia.example.core.service.HelloService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RemoteHelloService implements HelloService {

	private HelloWorldApiClient helloWorldApiClient;

	public RemoteHelloService(HelloWorldApiClient helloWorldApiClient) {
		log.info("Configured endpoint {}", helloWorldApiClient);
		this.helloWorldApiClient = helloWorldApiClient;
	}

	@Override
	public IdentidadDigitalDomain getHello(String name) {

		/*
		ResponseEntity<IdentidadDigitalConsulta> response = helloWorldApiClient.getHelloByName(name, null);

		if (response.getBody() != null) {
			return response.getBody().getNombre();
		}
		*/
		IdentidadDigitalDomain response = new IdentidadDigitalDomain();
		response.setNombre("Hola "+name+ " !!");
		return response;
	}

}