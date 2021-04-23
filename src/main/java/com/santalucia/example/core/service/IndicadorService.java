package com.santalucia.example.core.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.santalucia.example.core.domain.IndicadoresCentroDomain;

public interface IndicadorService {

	public List<IndicadoresCentroDomain> getIndicadores(Pageable pageable);
}
