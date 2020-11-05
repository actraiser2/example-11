package com.santalucia.example.api.delegate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.santalucia.example.api.model.Agencia;
import com.santalucia.example.api.web.AgenciasApiDelegate;
import com.santalucia.example.core.converters.AgenciaConverter;
import com.santalucia.example.core.domain.AgenciaDomain;
import com.santalucia.example.core.service.AgenciaService;

@Component
public class DefaultAgenciasApiDelegate implements AgenciasApiDelegate {

	private final AgenciaService agenciaService;

	private final AgenciaConverter agenciaConverter;

	public DefaultAgenciasApiDelegate(final AgenciaService agenciaService, final AgenciaConverter agenciaConverter) {
		this.agenciaService = agenciaService;
		this.agenciaConverter = agenciaConverter;
	}

	@Override
	public ResponseEntity<List<Agencia>> getAgenciasList(Optional<UUID> xRequestId) {

		List<Agencia> listAgencias = new ArrayList<>();
		// AgenciaConverter converter = Mappers.getMapper(AgenciaConverter.class);

		List<AgenciaDomain> listAgenciasDomain = this.agenciaService.getAgencias();
		listAgenciasDomain.forEach((agenciaDomain) -> {
			Agencia agencia = agenciaConverter.convertAgenciaDomainToAgencia(agenciaDomain);
			listAgencias.add(agencia);
		});

		return new ResponseEntity<List<Agencia>>(listAgencias, HttpStatus.OK);
	}

}
