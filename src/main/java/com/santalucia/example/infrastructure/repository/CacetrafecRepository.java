package com.santalucia.example.infrastructure.repository;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.data.domain.Pageable;

import com.santalucia.example.infrastructure.entity.Cacetrafec;

public interface CacetrafecRepository {

	public List<Cacetrafec> getIndicadores();	
	public List<Cacetrafec> getIndicadores(Pageable pageable);

}
