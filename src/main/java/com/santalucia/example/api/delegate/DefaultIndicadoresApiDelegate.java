package com.santalucia.example.api.delegate;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import java.util.concurrent.CompletableFuture;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.santalucia.example.api.model.IndicadorResource;
import com.santalucia.example.api.server.IndicadoresApiDelegate;
import com.santalucia.example.core.mappers.CacetrafecDomainMapper;
import com.santalucia.example.core.service.IndicadorService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class DefaultIndicadoresApiDelegate implements IndicadoresApiDelegate{

	private final IndicadorService indicadorService;
	private final CacetrafecDomainMapper cacetrafecMapper;

    /**
     * constructor de clase
     */
	public DefaultIndicadoresApiDelegate(IndicadorService indicadorService, CacetrafecDomainMapper cacetrafecMapper) {
		super();
		this.indicadorService = indicadorService;
		this.cacetrafecMapper = cacetrafecMapper;
	}

    /**
     * listado de indicadores
     *
     * @param Optional<UUID> xRequestID
     * @param Pageable       pageable
     * @return ResponseEntity<List < IndicadorResource>>
     */
	@Override
	public CompletableFuture<ResponseEntity<List<IndicadorResource>>> getIndicadoresList(Optional<UUID> xRequestID, Pageable pageable) {

		log.info("Pageable pagenumber: {} ", pageable.getPageNumber());
		log.info("Pageable pageSize: {} ", pageable.getPageSize());
		log.info("Pageable offset: {} ", pageable.getOffset());

    return CompletableFuture.supplyAsync(() -> Optional
      .of(this.indicadorService.getIndicadores(pageable))
      .map(indicadores -> ResponseEntity.ok().body(this.cacetrafecMapper.indicadoresDomainToResources(indicadores)))
      .orElse(ResponseEntity.notFound().build()), Runnable::run);

	}


}
