package com.santalucia.example.core.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.santalucia.arq.ams.data.jdbc.constants.DatasourceConstants;
import com.santalucia.example.core.domain.IndicadoresCentroDomain;
import com.santalucia.example.core.mappers.CacetrafecDomainMapper;
import com.santalucia.example.infrastructure.entity.Cacetrafec;
import com.santalucia.example.infrastructure.repository.primary.CacetrafecPageableRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * DefaultIndicadorService
 *
 */
@Service
@AllArgsConstructor
@Transactional(value = DatasourceConstants.PRIMARY_TRANSACTION_MANAGER)
@Slf4j
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
		log.info("Thread2 {}", Thread.currentThread());
		
		try {
			var text = Files.readString(Path.of("c:/tmp/selead-secret.yaml"));
			//Thread.sleep(4000);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		log.info("Thread3 {}", Thread.currentThread());
		Page<Cacetrafec> lstEntity = cacetrafecPageableRepository.findAll(pageable);
		log.info("Thread4 {}", Thread.currentThread());
		
		return cacetrafecMapper.cacetrafecEntitiestoDomains(lstEntity.stream().toList());
	}
}
