package com.santalucia.example.api.delegate;



import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.santalucia.example.api.model.IndicadorResource;
import com.santalucia.example.api.server.ListIndicadoresApiDelegate;
import com.santalucia.example.core.mappers.CacetrafecDomainMapper;
import com.santalucia.example.core.service.IndicadorService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Component
public class DefaultIndicadoresApiDelegate implements ListIndicadoresApiDelegate {

  private final IndicadorService indicadorService;
  private final CacetrafecDomainMapper cacetrafecMapper;  

  /**
   * listado de indicadores
   *
   * @param Optional<UUID> xRequestID
   * @param Pageable       pageable
   * @return ResponseEntity<List < IndicadorResource>>  
   */
  @Override
  public ResponseEntity<List<IndicadorResource>> getIndicadoresList(Optional<UUID> xRequestID, Pageable pageable) {
	log.info("Thread1 {} name {}, isVirtual  {}", Thread.currentThread(), 
			Thread.currentThread().getName(),  Thread.currentThread().isVirtual());
	
    return Optional
      .ofNullable(this.indicadorService.getIndicadores(pageable))
      .map(indicadores -> ResponseEntity.ok().body(this.cacetrafecMapper.indicadoresDomainToResources(indicadores)))
      .orElseGet(() -> ResponseEntity.notFound().build());
  }


}
