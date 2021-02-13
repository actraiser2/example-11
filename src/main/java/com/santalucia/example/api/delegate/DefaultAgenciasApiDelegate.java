package com.santalucia.example.api.delegate;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.santalucia.example.api.model.Agencia;
import com.santalucia.example.api.server.AgenciasApiDelegate;
import com.santalucia.example.core.domain.AgenciaDomain;
import com.santalucia.example.core.mappers.AgenciaDomainMapper;
import com.santalucia.example.core.service.AgenciaService;

@Component
public class DefaultAgenciasApiDelegate implements AgenciasApiDelegate {

	private final AgenciaService agenciaService;

	private final AgenciaDomainMapper agenciaDomainMapper;

	public DefaultAgenciasApiDelegate(final AgenciaService agenciaService,
			final AgenciaDomainMapper agenciaDomainMapper) {
		this.agenciaService = agenciaService;
		this.agenciaDomainMapper = agenciaDomainMapper;
	}

	@Override
	public ResponseEntity<List<Agencia>> getAgenciasList(Optional<UUID> xRequestId) {

		List<AgenciaDomain> listAgenciasDomain = this.agenciaService.getAgencias();
		List<Agencia> listAgencias = agenciaDomainMapper.toApis(listAgenciasDomain);

		return new ResponseEntity<>(listAgencias, HttpStatus.OK);
	}

}
