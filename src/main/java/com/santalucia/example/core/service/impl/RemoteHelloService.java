package com.santalucia.example.core.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.santalucia.example.core.service.HelloService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RemoteHelloService implements HelloService {

	private RestTemplate restTemplate;

	public RemoteHelloService(RestTemplateBuilder builder,
			@Value("${santalucia.endpoint.example.uri}") String remoteExampleUri) {
		log.info("Configured endpoint {}", remoteExampleUri);
		this.restTemplate = builder.defaultHeader("Content-Type", "application/json").rootUri(remoteExampleUri).build();
	}

	@Override
	public String getHello(String name) {

		String response = restTemplate.getForObject("/hello/{name}", String.class, name);

		return response;
	}

}
