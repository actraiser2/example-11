package com.santalucia.example.api.delegate;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.santalucia.example.api.model.AgenciaResource;
import com.santalucia.example.api.server.AgenciasApiDelegate;
import com.santalucia.example.core.mappers.CacetrafecDomainMapper;
import com.santalucia.example.core.service.AgenciaService;

@Component
public class DefaultAgenciasApiDelegate implements AgenciasApiDelegate {

	private final AgenciaService agenciaService;
	private final CacetrafecDomainMapper cacetrafecMapper;

	public DefaultAgenciasApiDelegate(AgenciaService agenciaService, CacetrafecDomainMapper cacetrafecMapper) {
		this.agenciaService = agenciaService;
		this.cacetrafecMapper = cacetrafecMapper;
	}

	@Override
	public ResponseEntity<List<AgenciaResource>> getAgenciasList(Optional<UUID> xRequestId) {

		return Optional
				.ofNullable(agenciaService.getAgencias())
				.map(agencias -> ResponseEntity.ok().body(cacetrafecMapper.toResources(agencias))) // 200 OK
				.orElse(ResponseEntity.notFound().build()); // 404 Not found

	}

}
