package com.santalucia.example.api.delegate;

import com.santalucia.example.api.model.IdentidadDigitalConsultaResource;
import com.santalucia.example.core.domain.IdentidadDigitalDomain;
import com.santalucia.example.core.mappers.IdentidadDigitalDomainMapper;
import com.santalucia.example.core.service.HelloService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.assertj.core.api.Assertions.assertThat;


import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class DefaultHelloNameApiDelegateTest {
  @Mock
  HelloService helloService;
  @Mock
  IdentidadDigitalDomainMapper identidadDigitalDomainMapper;

  @Test
  @DisplayName("Dado un contexto de prueba, probamos respuesta de la llamada a get hello name")
  void test_hello_by_name_delegate() {
    DefaultHelloNameApiDelegate delegate = new DefaultHelloNameApiDelegate(helloService, identidadDigitalDomainMapper);

    when(helloService.getHelloByName(anyString())).thenReturn(IdentidadDigitalDomain.builder().nombre("Pepe").saludo("Hola").build());
    when(helloService.getHelloByName(isNull())).thenReturn(null);

    when(identidadDigitalDomainMapper.toResource(any(IdentidadDigitalDomain.class))).thenReturn(new IdentidadDigitalConsultaResource("Pepe", "Hola"));


    CompletableFuture<ResponseEntity<IdentidadDigitalConsultaResource>> completableFuture =
      delegate.getHelloByName("Pepe", null);
    assertThat(completableFuture).isNotNull();
    assertThat(completableFuture.join().getStatusCodeValue()).isEqualTo(200);
    assertThat(completableFuture.join().getBody()).isEqualTo(new IdentidadDigitalConsultaResource("Pepe", "Hola"));

    CompletableFuture<ResponseEntity<IdentidadDigitalConsultaResource>> completableFuture2 =
      delegate.getHelloByName(null, null);
    assertThat(completableFuture2).isNotNull();
    assertThat(completableFuture2.join().getStatusCodeValue()).isEqualTo(404);
    assertThat(completableFuture2.join().getBody()).isNull();


  }

  @Test
  @DisplayName("Dado un contexto de prueba, probamos respuesta de la llamada a get hello by name remote")
  void test_hello_by_name_remote_delegate() {
    DefaultHelloNameApiDelegate delegate = new DefaultHelloNameApiDelegate(helloService, identidadDigitalDomainMapper);

    when(helloService.getHelloRemoteByName(anyString())).thenReturn(Optional.of(IdentidadDigitalDomain.builder().nombre("Juan").saludo("Hola").build()));
    when(helloService.getHelloRemoteByName(isNull())).thenReturn(null);

    when(identidadDigitalDomainMapper.toResource(any(IdentidadDigitalDomain.class))).thenReturn(new IdentidadDigitalConsultaResource("Juan", "Hola"));

    CompletableFuture<ResponseEntity<IdentidadDigitalConsultaResource>> completableFuture =
      delegate.getHelloByNameRemote("Juan", null);
    assertThat(completableFuture).isNotNull();
    assertThat(completableFuture.join().getStatusCodeValue()).isEqualTo(200);
    assertThat(completableFuture.join().getBody()).isEqualTo(new IdentidadDigitalConsultaResource("Juan", "Hola"));

    CompletableFuture<ResponseEntity<IdentidadDigitalConsultaResource>> completableFuture2 =
      delegate.getHelloByNameRemote(null, null);
    assertThat(completableFuture2).isNotNull();
    assertThat(completableFuture2.join().getStatusCodeValue()).isEqualTo(404);
    assertThat(completableFuture2.join().getBody()).isNull();
  }
}
