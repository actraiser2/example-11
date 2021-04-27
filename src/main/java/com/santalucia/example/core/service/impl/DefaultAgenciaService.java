package com.santalucia.example.core.service.impl;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.santalucia.arq.ams.componentes.database.properties.DatasourceProperties;
import com.santalucia.example.core.domain.AgenciaDomain;
import com.santalucia.example.core.mappers.CacetrafecDomainMapper;
import com.santalucia.example.core.service.AgenciaService;
import com.santalucia.example.infrastructure.repository.CacetrafecRepository;

@Service
@Transactional(value = DatasourceProperties.PRIMARY_TRANSACTION_MANAGER)
public class DefaultAgenciaService implements AgenciaService {

	private final CacetrafecRepository cacetrafecRepository;
	private final CacetrafecDomainMapper cacetrafecMapper;

	public DefaultAgenciaService(final CacetrafecRepository cacetrafecRepository, CacetrafecDomainMapper cacetrafecMapper) {
		this.cacetrafecRepository = cacetrafecRepository;
		this.cacetrafecMapper = cacetrafecMapper;
	}

    /**
     * getAgencias
     * @return List<AgenciaDomain>
     */
	@Override
	public List<AgenciaDomain> getAgencias() {
		return null;
	}

    /**
     * getAgencias
     * @param Pageable pageable
     * @return List<AgenciaDomain>
     */
	@Override
	public List<AgenciaDomain> getAgencias(Pageable pageable) {
		return null;
	}

}
