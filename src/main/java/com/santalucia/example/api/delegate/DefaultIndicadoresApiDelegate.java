package com.santalucia.example.api.delegate;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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
	
	public DefaultIndicadoresApiDelegate(IndicadorService indicadorService, CacetrafecDomainMapper cacetrafecMapper) {
		super();
		this.indicadorService = indicadorService;
		this.cacetrafecMapper = cacetrafecMapper;
	}
	
	@Override
	public ResponseEntity<List<IndicadorResource>> getIndicadoresList(Optional<UUID> xRequestID, Pageable pageable) {
		
		log.info("Pageable pagenumber: {} ", pageable.getPageNumber());
		log.info("Pageable pageSize: {} ", pageable.getPageSize());
		log.info("Pageable offset: {} ", pageable.getOffset());
		
		return Optional
			.ofNullable(this.indicadorService.getIndicadores(pageable))
			.map(indicadores -> ResponseEntity.ok().body(this.cacetrafecMapper.indicadoresDomainToResources(indicadores)))
			.orElse(ResponseEntity.notFound().build());
	}

	
}
