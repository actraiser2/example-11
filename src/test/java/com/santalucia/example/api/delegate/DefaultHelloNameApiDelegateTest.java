package com.santalucia.example.api.delegate;

import com.santalucia.example.api.model.IdentidadDigitalConsultaResource;
import com.santalucia.example.core.domain.IdentidadDigitalDomain;
import com.santalucia.example.core.mappers.IdentidadDigitalDomainMapper;
import com.santalucia.example.core.service.HelloService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DefaultHelloNameApiDelegateTest {
  @Mock
  HelloService helloService;
  @Mock
  IdentidadDigitalDomainMapper identidadDigitalDomainMapper;

  @Test
  @DisplayName("Dado un contexto de prueba, probamos que respuesta hello by name es  correcta")
  void getHelloByName() {
    DefaultHelloNameApiDelegate delegate = new DefaultHelloNameApiDelegate(helloService, identidadDigitalDomainMapper);

    when(helloService.getHelloByName(anyString())).thenReturn(IdentidadDigitalDomain.builder().nombre("Pepe").saludo("Hola").build());
    when(helloService.getHelloByName(isNull())).thenReturn(null);

    when(identidadDigitalDomainMapper.toResource(any(IdentidadDigitalDomain.class))).thenReturn(new IdentidadDigitalConsultaResource("Pepe", "Hola"));


    CompletableFuture<ResponseEntity<IdentidadDigitalConsultaResource>> completableFuture =
      delegate.getHelloByName("Pepe", null);
    assertNotNull(completableFuture);
    assertEquals(200, completableFuture.join().getStatusCodeValue());
    assertEquals(new IdentidadDigitalConsultaResource("Pepe", "Hola"), completableFuture.join().getBody());

    CompletableFuture<ResponseEntity<IdentidadDigitalConsultaResource>> completableFuture2 =
      delegate.getHelloByName(null, null);
    assertNotNull(completableFuture2);
    assertEquals(404, completableFuture2.join().getStatusCodeValue());
    assertNull(completableFuture2.join().getBody());


  }

  @Test
  void getHelloByNameRemote() {
    DefaultHelloNameApiDelegate delegate = new DefaultHelloNameApiDelegate(helloService, identidadDigitalDomainMapper);

    when(helloService.getHelloRemoteByName(anyString())).thenReturn(Optional.of(IdentidadDigitalDomain.builder().nombre("Juan").saludo("Hola").build()));
    when(helloService.getHelloRemoteByName(isNull())).thenReturn(null);

    when(identidadDigitalDomainMapper.toResource(any(IdentidadDigitalDomain.class))).thenReturn(new IdentidadDigitalConsultaResource("Juan", "Hola"));

    CompletableFuture<ResponseEntity<IdentidadDigitalConsultaResource>> completableFuture =
      delegate.getHelloByNameRemote("Juan", null);
    assertNotNull(completableFuture);
    assertEquals(200, completableFuture.join().getStatusCodeValue());
    assertEquals(new IdentidadDigitalConsultaResource("Juan", "Hola"), completableFuture.join().getBody());

    CompletableFuture<ResponseEntity<IdentidadDigitalConsultaResource>> completableFuture2 =
      delegate.getHelloByNameRemote(null, null);
    assertNotNull(completableFuture2);
    assertEquals(404, completableFuture2.join().getStatusCodeValue());
    assertNull(completableFuture2.join().getBody());

  }
}
