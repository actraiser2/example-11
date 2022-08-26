package com.santalucia.example.api.delegate;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.santalucia.example.api.model.IndicadorResource;
import com.santalucia.example.api.server.IndicadoresApiDelegate;
import com.santalucia.example.core.mappers.CacetrafecDomainMapper;
import com.santalucia.example.core.service.IndicadorService;

import lombok.AllArgsConstructor;


/**
 * DefaultIndicadoresApiDelegate
 *
 */
@Component
@AllArgsConstructor
public class DefaultIndicadoresApiDelegate implements IndicadoresApiDelegate {

  private final IndicadorService indicadorService;
  private final CacetrafecDomainMapper cacetrafecMapper;

  /**
   * listado de indicadores
   *
   * @param Optional<UUID> xRequestID
   * @param Pageable       pageable
   * @return ResponseEntity<List < IndicadorResource>>
   */
  @Async
  @Override
  public CompletableFuture<ResponseEntity<List<IndicadorResource>>> getIndicadoresList(Optional<UUID> xRequestID, Pageable pageable) {

    return CompletableFuture.completedFuture( Optional
      .ofNullable(this.indicadorService.getIndicadores(pageable))
      .map(indicadores -> ResponseEntity.ok().body(this.cacetrafecMapper.indicadoresDomainToResources(indicadores)))
      .orElse(ResponseEntity.notFound().build()));
  }


}
