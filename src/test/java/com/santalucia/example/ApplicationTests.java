package com.santalucia.example;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {

	@Test
	void contextLoads() {
		// Application.main(new String[] {}); //TODO Arreglar ya que carga el contexto 2
		// veces
		assertTrue(true); // TODO: cambiar a assertNoexception
	}

}
