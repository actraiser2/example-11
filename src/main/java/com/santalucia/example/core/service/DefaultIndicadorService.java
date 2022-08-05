package com.santalucia.example.core.service;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.santalucia.arq.ams.componentes.database.properties.DatasourceProperties;
import com.santalucia.example.core.domain.IndicadoresCentroDomain;
import com.santalucia.example.core.mappers.CacetrafecDomainMapper;
import com.santalucia.example.infrastructure.entity.Cacetrafec;
import com.santalucia.example.infrastructure.repository.CacetrafecRepository;

@Service
@Transactional(value = DatasourceProperties.PRIMARY_TRANSACTION_MANAGER)
public class DefaultIndicadorService implements IndicadorService{

	private final CacetrafecRepository cacetrafecRepository;
	private final CacetrafecDomainMapper cacetrafecMapper;

    /**
     * constructor de clase
     * @param CacetrafecRepository cacetrafecRepository
     * @param CacetrafecDomainMapper cacetrafecMapper
     */
	public DefaultIndicadorService(CacetrafecRepository cacetrafecRepository, CacetrafecDomainMapper cacetrafecMapper) {
		this.cacetrafecRepository = cacetrafecRepository;
		this.cacetrafecMapper = cacetrafecMapper;
	}

    /**
     * recupera los indicadores paginados
     * @param Pageable pageable
     * @return List<IndicadoresCentroDomain>
     */
	@Override
	public List<IndicadoresCentroDomain> getIndicadores(Pageable pageable) {
		List<Cacetrafec> lstEntity = cacetrafecRepository.getIndicadores(pageable);
		return cacetrafecMapper.cacetrafecEntitiestoDomains(lstEntity);
	}

}
