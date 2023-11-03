package com.santalucia.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.context.WebApplicationContext;

import lombok.Generated;

import static org.assertj.core.api.Assertions.assertThat;

//Hay que incluir @Generated para evitar que compute en cobertura
@Generated
@SpringBootTest
class ApplicationTests {

	@Test
	@DisplayName("Prueba integrada de carga de contexto")
	void contextLoads(WebApplicationContext context) {
		assertThat(context).isNotNull();
	}

}
