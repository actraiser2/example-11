package com.santalucia.example.core.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.santalucia.example.core.domain.AgenciaDomain;

public interface AgenciaService {

    /**
     * getAgencias
     * @return List<AgenciaDomain>
     */
	public List<AgenciaDomain> getAgencias();
	
    /**
     * getAgencias
     * @param Pageable pageable
     * @return List<AgenciaDomain>
     */
	public List<AgenciaDomain> getAgencias(Pageable pageable);

}
