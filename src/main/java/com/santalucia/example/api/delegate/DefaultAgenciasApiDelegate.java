package com.santalucia.example.api.delegate;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.santalucia.example.api.model.AgenciaResource;
import com.santalucia.example.api.server.AgenciasApiDelegate;
import com.santalucia.example.core.domain.AgenciaDomain;
import com.santalucia.example.core.mappers.CacetrafecDomainMapper;
import com.santalucia.example.core.service.AgenciaService;

@Component
public class DefaultAgenciasApiDelegate implements AgenciasApiDelegate {

	private final AgenciaService agenciaService;


	public DefaultAgenciasApiDelegate(final AgenciaService agenciaService) {
		this.agenciaService = agenciaService;
	}

	@Override
	public ResponseEntity<List<AgenciaResource>> getAgenciasList(Optional<UUID> xRequestId) {
		return new ResponseEntity<>(this.agenciaService.getAgencias(), HttpStatus.OK);
	}

}
