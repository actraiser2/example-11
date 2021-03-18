package com.santalucia.example;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.santalucia.arq.ams.componentes.exceptions.api.model.Error407Resource;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class ApplicationTests {

	@Test
	void contextLoads() {
		// Application.main(new String[] {}); //TODO Arreglar ya que carga el contexto 2
		// veces
		Error407Resource e = new Error407Resource();
		log.info("hola {}",e.getMensaje());
		assertTrue(true); // TODO: cambiar a assertNoexception
	}

}
