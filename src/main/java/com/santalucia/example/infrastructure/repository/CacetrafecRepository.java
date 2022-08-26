package com.santalucia.example.infrastructure.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.santalucia.example.infrastructure.entity.Cacetrafec;

public interface CacetrafecRepository {

    /**
     * getIndicadores
     * @return List<Cacetrafec>
     */
	List<Cacetrafec> getIndicadores();

    /**
     * getIndicadores
     * @param Pageable pageable
     * @return List<Cacetrafec>
     */
	List<Cacetrafec> getIndicadores(Pageable pageable);

}
