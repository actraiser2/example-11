package com.santalucia.example.infrastructure.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.santalucia.example.infrastructure.entity.Cacetrafec;

public interface CacetrafecRepository {

	public List<Cacetrafec> getAgencias();
	public List<Cacetrafec> getAgencias(Pageable pageable);

}
