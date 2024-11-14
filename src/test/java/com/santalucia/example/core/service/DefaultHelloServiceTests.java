package com.santalucia.example.core.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.instancio.Instancio;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.santalucia.example.core.domain.IdentidadDigitalDomain;
import com.santalucia.example.core.mappers.IdentidadDigitalDomainMapper;

@ExtendWith(SpringExtension.class)
class DefaultHelloServiceTests {

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
		IdentidadDigitalDomain identidadDomain = Instancio.create(IdentidadDigitalDomain.class);
		identidadDomain.setNombre(name);


		when(identidadDigitalMapper.toDomain(Mockito.any())).thenReturn(identidadDomain);

		Optional<IdentidadDigitalDomain> greeting = helloService.getHelloRemoteByName(name);

		// then
		assertThat(greeting).map(IdentidadDigitalDomain::getNombre).hasValue(name);

	}

}
