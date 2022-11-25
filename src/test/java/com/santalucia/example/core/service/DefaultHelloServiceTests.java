package com.santalucia.example.core.service;

import com.santalucia.example.api.client.HelloWorldApiClient;
import com.santalucia.example.api.model.IdentidadDigitalConsultaResource;
import com.santalucia.example.core.domain.IdentidadDigitalDomain;
import com.santalucia.example.core.domain.IdentidadDigitalDomain.IdentidadDigitalDomainBuilder;
import com.santalucia.example.core.mappers.IdentidadDigitalDomainMapper;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

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

		//given
		final String name = "mundo";

		//when
		IdentidadDigitalDomain greeting = helloService.getHelloByName(name);

		//then
		assertThat(greeting.getNombre()).isEqualTo(name);
	}

	@Test
	@DisplayName("Recupera un saludo del servicio remoto")
	void testGetHelloRemoteByname() {

		//given
		final String name = "mundo";
		IdentidadDigitalConsultaResource response = buildIdentidadDigitalConsultaResource(name);
		IdentidadDigitalDomain identidadDomain = buildIdentidadDigitalDomain(name);

		//when
		when(helloWorldApiClient.getHelloByName(Mockito.anyString(), Mockito.any()))
			.thenReturn(CompletableFuture.completedFuture(new ResponseEntity<>(response, HttpStatus.OK)));
		when(identidadDigitalMapper.toDomain(Mockito.any())).thenReturn(identidadDomain);

		Optional<IdentidadDigitalDomain> greeting = helloService.getHelloRemoteByName(name);

		//then
		assertThat(greeting).map(IdentidadDigitalDomain::getNombre).hasValue(name);

	}

	private IdentidadDigitalConsultaResource buildIdentidadDigitalConsultaResource(String nombre) {
    	IdentidadDigitalConsultaResource response = new IdentidadDigitalConsultaResource();
    	response.setNombre(nombre);
    	response.setSaludo(String.format("Hello %s", nombre));
    	return response;
    }

	private IdentidadDigitalDomain buildIdentidadDigitalDomain(String nombre) {
    	IdentidadDigitalDomainBuilder identidad = IdentidadDigitalDomain.builder();
		identidad.nombre(nombre);
		identidad.saludo(String.format("Hello %s", nombre));
		return identidad.build();
    }

}
