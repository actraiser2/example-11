package com.santalucia.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationIT {

  @Test
  @DisplayName("Prueba integrada de carga de contexto")
  void contextLoads() throws Exception {
    throw new Exception("Error");
  }

}
