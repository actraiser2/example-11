package com.santalucia.example.core.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;

import com.santalucia.example.core.domain.IdentidadDigitalDomain;

@SpringBootTest
@AutoConfigureWireMock(port=0)
class RemoteHelloServiceTest {
	
	@Autowired
	private RemoteHelloService remoteHelloService;

	@Test
	@DisplayName("Recupera un saludo del servicio remoto")
	void testGetHello() {
		
		//given
		final String name = "mundo";
		
		//when
		IdentidadDigitalDomain greeting = remoteHelloService.getHello(name);
		
		//then
		assertEquals(name, greeting.getNombre());
	}

}
