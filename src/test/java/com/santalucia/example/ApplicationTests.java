package com.santalucia.example;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
class ApplicationTests {

	@Test
	@DisplayName("Prueba integrada de carga de contexto")
	void contextLoads(WebApplicationContext context) {
		assertThat(context).isNotNull();
	}

}
