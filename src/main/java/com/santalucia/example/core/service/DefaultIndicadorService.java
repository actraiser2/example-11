package com.santalucia.example.core.service;

import java.util.List;


import com.santalucia.arq.ams.data.jdbc.constants.DatasourceConstants;
import com.santalucia.example.infrastructure.repository.primary.CacetrafecPageableRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.santalucia.example.core.domain.IndicadoresCentroDomain;
import com.santalucia.example.core.mappers.CacetrafecDomainMapper;
import com.santalucia.example.infrastructure.entity.Cacetrafec;

/**
 * DefaultIndicadorService
 *
 */
@Service
@AllArgsConstructor
@Transactional(value = DatasourceConstants.PRIMARY_TRANSACTION_MANAGER)
public class DefaultIndicadorService implements IndicadorService {

	private final CacetrafecPageableRepository cacetrafecPageableRepository;
	private final CacetrafecDomainMapper cacetrafecMapper;

    /**
     * recupera los indicadores paginados
     * @param pageable Pageable
     * @return List<IndicadoresCentroDomain>
     */
	@Override
	public List<IndicadoresCentroDomain> getIndicadores(Pageable pageable) {
		Page<Cacetrafec> lstEntity = cacetrafecPageableRepository.findAll(pageable);
		return cacetrafecMapper.cacetrafecEntitiestoDomains(lstEntity.stream().toList());
	}
}
