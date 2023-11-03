package com.santalucia.example.core.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import org.instancio.Instancio;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.santalucia.example.api.client.HelloWorldApiClient;
import com.santalucia.example.api.model.IdentidadDigitalConsultaResource;
import com.santalucia.example.core.domain.IdentidadDigitalDomain;
import com.santalucia.example.core.mappers.IdentidadDigitalDomainMapper;

@ExtendWith(SpringExtension.class)
class DefaultHelloServiceTests {

	@Mock
	private HelloWorldApiClient helloWorldApiClient;

	@Mock
	private IdentidadDigitalDomainMapper identidadDigitalMapper;

	@InjectMocks
	private DefaultHelloService helloService;

	@Test
	@DisplayName("Recupera un saludo del servicio")
	void testGetHelloByname() {

		// given
		final String name = "mundo";

		// when
		IdentidadDigitalDomain greeting = helloService.getHelloByName(name);

		// then
		assertThat(greeting.getNombre()).isEqualTo(name);
	}

	@Test
	@DisplayName("Recupera un saludo del servicio remoto")
	void testGetHelloRemoteByname() {

		// given
		final String name = "mundo";
		IdentidadDigitalConsultaResource response = Instancio.create(IdentidadDigitalConsultaResource.class);
		IdentidadDigitalDomain identidadDomain = Instancio.create(IdentidadDigitalDomain.class);
		identidadDomain.setNombre(name);

		// when
		when(helloWorldApiClient.getHelloByName(Mockito.anyString(), Mockito.any()))
				.thenReturn(CompletableFuture.completedFuture(new ResponseEntity<>(response, HttpStatus.OK)));
		when(identidadDigitalMapper.toDomain(Mockito.any())).thenReturn(identidadDomain);

		Optional<IdentidadDigitalDomain> greeting = helloService.getHelloRemoteByName(name);

		// then
		assertThat(greeting).map(IdentidadDigitalDomain::getNombre).hasValue(name);

	}

}
