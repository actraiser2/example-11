package com.santalucia.example.api.delegate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.mapstruct.factory.Mappers;
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

	public DefaultAgenciasApiDelegate(final AgenciaService agenciaService) {
		this.agenciaService = agenciaService;
	}

	@Override
	public ResponseEntity<List<Agencia>> getAgenciasList(Optional<UUID> xRequestId) {

		// List<Agencia> listAgencias = new ArrayList<>();
		// AgenciaConverter converter = Mappers.getMapper(AgenciaConverter.class);
		//
		// List<AgenciaDomain> listAgenciasDomain = this.agenciaService.getAgencias();
		// listAgenciasDomain.forEach((agenciaDomain) -> {
		// Agencia agencia = converter.convertAgenciaDomainToAgencia(agenciaDomain);
		// listAgencias.add(agencia);
		// });

		List<Agencia> listAgencias = this.agenciaService.getAgencias();

		return new ResponseEntity<List<Agencia>>(listAgencias, HttpStatus.OK);
	}

}
