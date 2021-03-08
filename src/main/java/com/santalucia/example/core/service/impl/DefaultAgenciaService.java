package com.santalucia.example.core.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.santalucia.example.core.domain.AgenciaDomain;
import com.santalucia.example.core.mappers.CacetrafecDomainMapper;
import com.santalucia.example.core.service.AgenciaService;
import com.santalucia.example.infrastructure.entity.Cacetrafec;
import com.santalucia.example.infrastructure.repository.CacetrafecRepository;

@Service
public class DefaultAgenciaService implements AgenciaService {

	private final CacetrafecRepository cacetrafecRepository;
	private final CacetrafecDomainMapper cacetrafecMapper;

	public DefaultAgenciaService(final CacetrafecRepository cacetrafecRepository, CacetrafecDomainMapper cacetrafecMapper) {
		this.cacetrafecRepository = cacetrafecRepository;
		this.cacetrafecMapper = cacetrafecMapper;
	}

	@Override
	public List<AgenciaDomain> getAgencias() {
		
		List<Cacetrafec> lstEntity = cacetrafecRepository.getAgencias();
		return cacetrafecMapper.toDomainsfromEntities(lstEntity);
	}

}
