package com.santalucia.example.infraestructure.dao.repository.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.santalucia.example.core.domain.AgenciaDomain;
import com.santalucia.example.infraestructure.dao.mappers.AgenciaMapper;
import com.santalucia.example.infraestructure.dao.repository.AgenciaRepository;

@Repository
public class DefaultAgenciaRepository implements AgenciaRepository {

	private final AgenciaMapper agenciaMapper;

	public DefaultAgenciaRepository(AgenciaMapper agenciaMapper) {
		this.agenciaMapper = agenciaMapper;
	}

	@Override
	public List<AgenciaDomain> getAgencias() {
		return this.agenciaMapper.getAgencias();
	}

}
