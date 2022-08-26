package com.santalucia.example.api.delegate;

import java.util.Optional;
import java.util.UUID;

import java.util.concurrent.CompletableFuture;

import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.santalucia.example.api.model.IdentidadDigitalConsultaResource;
import com.santalucia.example.api.server.HelloApiDelegate;
import com.santalucia.example.core.mappers.IdentidadDigitalDomainMapper;
import com.santalucia.example.core.service.HelloService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;


/**
 * DefaultHelloNameApiDelegate
 *
 */
@Slf4j
@Component
@AllArgsConstructor
public class DefaultHelloNameApiDelegate implements HelloApiDelegate {

  private final HelloService helloService;
  private final IdentidadDigitalDomainMapper identidadDigitalDomainMapper;


  /**
   * DefaultHelloNameApiDelegate getHelloByName
   * @param String name
   * @param Optional<UUID> xRequestID
   */
  @Async
  @Override
  public CompletableFuture<ResponseEntity<IdentidadDigitalConsultaResource>> getHelloByName(String name, Optional<UUID> xRequestID) {
    log.debug("processing getHelloByName");

    return CompletableFuture.completedFuture(
      Optional
        .ofNullable(helloService.getHelloByName(name))
        .map(idDomain -> ResponseEntity.ok().body(identidadDigitalDomainMapper.toResource(idDomain))) // 200 OK
        .orElse(ResponseEntity.notFound().build()));// 404 Not found

  }


  /**
   * DefaultHelloNameApiDelegate getHelloByNameRemote
   * @param String name
   * @param Optional<UUID> xRequestID
   * 
   */
  @Async
  @Override
  public CompletableFuture<ResponseEntity<IdentidadDigitalConsultaResource>> getHelloByNameRemote(String name,
                                                                                                  Optional<UUID> xRequestID) {
    log.debug("processing getHelloByNameRemote");
      return CompletableFuture.completedFuture(
        Optional
          .ofNullable(helloService.getHelloRemoteByName(name))
          .flatMap(optional -> optional)
          .map(idDomain -> ResponseEntity.ok().body(identidadDigitalDomainMapper.toResource(idDomain))) // 200 OK
          .orElse(ResponseEntity.notFound().build()));
  }

}
