package com.santalucia.example.infrastructure.dao.repository.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.santalucia.example.core.domain.AgenciaDomain;
import com.santalucia.example.infrastructure.dao.repository.AgenciaRepository;
import com.santalucia.example.infrastructure.mybatisnformix.mappers.AgenciaDaoMapper;

@Repository
public class DefaultAgenciaRepository implements AgenciaRepository {

	private final AgenciaDaoMapper agenciaDaoMapper;

	public DefaultAgenciaRepository(AgenciaDaoMapper agenciaDaoMapper) {
		this.agenciaDaoMapper = agenciaDaoMapper;
	}

	@Override
	public List<AgenciaDomain> getAgencias() {
		return this.agenciaDaoMapper.getAgencias();
	}

}
