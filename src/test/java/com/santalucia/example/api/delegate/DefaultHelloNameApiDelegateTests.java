package com.santalucia.example.api.delegate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.santalucia.example.api.model.IdentidadDigitalConsultaResource;
import com.santalucia.example.core.domain.IdentidadDigitalDomain;
import com.santalucia.example.core.mappers.IdentidadDigitalDomainMapper;
import com.santalucia.example.core.service.HelloService;

@ExtendWith(SpringExtension.class)
class DefaultHelloNameApiDelegateTests {

  @Mock
  private HelloService helloService;

  @Mock
  private IdentidadDigitalDomainMapper identidadDigitalDomainMapper;

  @Test
  @DisplayName("Dado un contexto de prueba, probamos respuesta de la llamada a get hello name")
  void test_hello_by_name_delegate() {
    DefaultHelloNameApiDelegate delegate = new DefaultHelloNameApiDelegate(helloService, identidadDigitalDomainMapper);
    IdentidadDigitalConsultaResource resource = new IdentidadDigitalConsultaResource();
    IdentidadDigitalDomain domain = IdentidadDigitalDomain.builder().nombre("User").saludo("Hola").build();

    when(helloService.getHelloByName(anyString())).thenReturn(domain);
    when(identidadDigitalDomainMapper.toResource(any(IdentidadDigitalDomain.class))).thenReturn(resource);


    CompletableFuture<ResponseEntity<IdentidadDigitalConsultaResource>> completableFuture = delegate.getHelloByName("User", Optional.empty());
    assertThat(completableFuture).isNotNull();
    assertThat(completableFuture.join().getStatusCode()).isEqualTo(HttpStatus.OK);
    assertThat(completableFuture.join().getBody()).isEqualTo(resource);
  }

//  @Test
//  @DisplayName("Dado un contexto de prueba, probamos respuesta de la llamada a get hello by name remote")
//  void test_hello_by_name_remote_delegate() {
//    DefaultHelloNameApiDelegate delegate = new DefaultHelloNameApiDelegate(helloService, identidadDigitalDomainMapper);
//    IdentidadDigitalConsultaResource resource = new IdentidadDigitalConsultaResource();
//    IdentidadDigitalDomain domain = IdentidadDigitalDomain.builder().nombre("User").saludo("Hola").build();
//
//    when(helloService.getHelloRemoteByName(anyString())).thenReturn(Optional.of(domain));
//    when(identidadDigitalDomainMapper.toResource(any(IdentidadDigitalDomain.class))).thenReturn(resource);
//
//    CompletableFuture<ResponseEntity<IdentidadDigitalConsultaResource>> completableFuture = delegate.getHelloByNameRemote("User", Optional.empty());
//
//    assertThat(completableFuture).isNotNull();
//    assertThat(completableFuture.join().getStatusCode()).isEqualTo(HttpStatus.OK);
//    assertThat(completableFuture.join().getBody()).isEqualTo(resource);
//  }
}
