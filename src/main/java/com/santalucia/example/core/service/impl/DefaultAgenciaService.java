package com.santalucia.example.core.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.santalucia.example.core.domain.AgenciaDomain;
import com.santalucia.example.core.service.AgenciaService;
import com.santalucia.example.infraestructure.dao.repository.AgenciaRepository;

@Service
public class DefaultAgenciaService implements AgenciaService {

	private final AgenciaRepository agenciaRepository;

	public DefaultAgenciaService(final AgenciaRepository agenciaRepository) {
		this.agenciaRepository = agenciaRepository;
	}

	@Override
	public List<AgenciaDomain> getAgencias() {
		return this.agenciaRepository.getAgencias();
	}

}
