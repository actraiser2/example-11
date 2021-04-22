package com.santalucia.example.core.service.impl;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.santalucia.example.core.domain.IndicadoresCentroDomain;
import com.santalucia.example.core.mappers.CacetrafecDomainMapper;
import com.santalucia.example.core.service.IndicadorService;
import com.santalucia.example.infrastructure.entity.Cacetrafec;
import com.santalucia.example.infrastructure.repository.CacetrafecRepository;

@Service
@Transactional(value = "primaryTransactionManager")
public class DefaultIndicadorService implements IndicadorService{

	private final CacetrafecRepository cacetrafecRepository;
	private final CacetrafecDomainMapper cacetrafecMapper;	
	
	public DefaultIndicadorService(CacetrafecRepository cacetrafecRepository, CacetrafecDomainMapper cacetrafecMapper) {
		this.cacetrafecRepository = cacetrafecRepository;
		this.cacetrafecMapper = cacetrafecMapper;
	}
	
	@Override
	public List<IndicadoresCentroDomain> getIndicadores(Pageable pageable) {
		List<Cacetrafec> lstEntity = cacetrafecRepository.getIndicadores(pageable);
		return cacetrafecMapper.cacetrafecEntitiestoDomains(lstEntity);
	}

}
