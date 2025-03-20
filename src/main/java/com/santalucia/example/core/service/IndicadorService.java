package com.santalucia.example.core.service;

import java.util.List;


import org.springframework.data.domain.Pageable;

import com.santalucia.example.core.domain.IndicadoresCentroDomain;


/**
 * IndicadorService
 *
 */
public interface IndicadorService {

    /**
     * getIndicadores
     * @param Pageable pageable
     * @return {@code List<IndicadoresCentroDomain>}
     */
	List<IndicadoresCentroDomain> getIndicadores(Pageable pageable);
}
