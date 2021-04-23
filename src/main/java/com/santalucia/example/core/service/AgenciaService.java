package com.santalucia.example.core.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.santalucia.example.core.domain.AgenciaDomain;

public interface AgenciaService {

	public List<AgenciaDomain> getAgencias();
	public List<AgenciaDomain> getAgencias(Pageable pageable);

}
