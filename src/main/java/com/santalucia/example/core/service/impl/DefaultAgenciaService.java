package com.santalucia.example.core.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.santalucia.example.core.domain.AgenciaDomain;
import com.santalucia.example.core.service.AgenciaService;
import com.santalucia.example.infraestructure.dao.mappers.AgenciaMapper;

@Service
public class DefaultAgenciaService implements AgenciaService {

	private final AgenciaMapper agenciaMapper;

	public DefaultAgenciaService(final AgenciaMapper agenciaMapper) {
		this.agenciaMapper = agenciaMapper;
	}

	@Override
	public List<AgenciaDomain> getAgencias() {
		return this.agenciaMapper.getAgencias();
	}

}
