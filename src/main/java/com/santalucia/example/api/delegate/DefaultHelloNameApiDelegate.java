package com.santalucia.example.api.delegate;

import java.util.Optional;
import java.util.UUID;

import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.composite.CompositeDiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import com.santalucia.example.api.model.IdentidadDigitalConsultaResource;
import com.santalucia.example.api.server.HelloWorldApiDelegate;
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
public class DefaultHelloNameApiDelegate implements HelloWorldApiDelegate {

  private final HelloService helloService;
  private final IdentidadDigitalDomainMapper identidadDigitalDomainMapper;
  private final RestClient restClient;
  private final DiscoveryClient discoveryClient;


  /**
   * DefaultHelloNameApiDelegate getHelloByName
   * @param String name
   * @param Optional<UUID> xRequestID
   */
  @Async
  @Override
  public ResponseEntity<IdentidadDigitalConsultaResource> getHelloByName(String name, Optional<UUID> xRequestID) {
    log.debug("processing getHelloByName");
    
    CompositeDiscoveryClient compositeDiscoveryClient = (CompositeDiscoveryClient)discoveryClient;
    
    log.info("discoveryClient service example-app-11 {}", 
    		compositeDiscoveryClient.getInstances("example-app-11"));
   
    
    String response = restClient.get().uri("/hello-world/v1/hello/jose").
    		retrieve().body(String.class);
    
    log.info("response {}", response);
   
    return 
      Optional
        .ofNullable(helloService.getHelloByName(name))
        .map(idDomain -> ResponseEntity.ok().body(identidadDigitalDomainMapper.toResource(idDomain))) // 200 OK
        .orElseGet(() -> ResponseEntity.notFound().build());// 404 Not found

  }
  
  
}
