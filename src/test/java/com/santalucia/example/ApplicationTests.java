package com.santalucia.example;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class ApplicationTests {

	@Test
	@DisplayName("Prueba integrada de carga de contexto")
	void contextLoads() {
    Assertions.assertThatCode(()  -> Application.main(new String[] {}))
      .doesNotThrowAnyException();
	}

}
