/*
 * Copyright 2002-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.santalucia.example.api.delegate;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.santalucia.example.api.model.IdentidadDigitalConsultaResource;
import com.santalucia.example.api.server.HelloApiDelegate;
import com.santalucia.example.core.mappers.IdentidadDigitalDomainMapper;
import com.santalucia.example.core.service.HelloService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class DefaultHelloNameApiDelegate implements HelloApiDelegate {

  private final HelloService helloService;
  private final IdentidadDigitalDomainMapper identidadDigitalDomainMapper;

  /**
   * constructor de clase
   *
   * @param HelloService                 helloService
   * @param IdentidadDigitalDomainMapper identidadDigitalDomainMapper
   */
  public DefaultHelloNameApiDelegate(HelloService helloService, IdentidadDigitalDomainMapper identidadDigitalDomainMapper) {
    this.helloService = helloService;
    this.identidadDigitalDomainMapper = identidadDigitalDomainMapper;
  }


  /**
   * DefaultHelloNameApiDelegate getHelloByName
   */
  @Override
  public CompletableFuture<ResponseEntity<IdentidadDigitalConsultaResource>> getHelloByName(String name, Optional<UUID> xRequestID) {
    log.debug("processing getHelloByName");

    return CompletableFuture.supplyAsync(() ->
        Optional
          .ofNullable(helloService.getHelloByName(name))
          .map(idDomain -> ResponseEntity.ok().body(identidadDigitalDomainMapper.toResource(idDomain))) // 200 OK
          .orElse(ResponseEntity.notFound().build()) // 404 Not found
      , Runnable::run);

  }


  /**
   * DefaultHelloNameApiDelegate getHelloByNameRemote
   */
  @Override
  public CompletableFuture<ResponseEntity<IdentidadDigitalConsultaResource>> getHelloByNameRemote(String name,
                                                                                                  Optional<UUID> xRequestID) {
    log.debug("processing getHelloByNameRemote");
    return CompletableFuture.supplyAsync(() ->
      {
        try {
          return Optional
            .of(helloService.getHelloRemoteByName(name))
            .flatMap(optional -> optional)
            .map(idDomain -> ResponseEntity.ok().body(identidadDigitalDomainMapper.toResource(idDomain))) // 200 OK
            .orElse(ResponseEntity.notFound().build());
        } catch (ExecutionException | InterruptedException e) {
          throw new RuntimeException(e);
        }
      } // 404 Not found
      , Runnable::run);

  }


}
