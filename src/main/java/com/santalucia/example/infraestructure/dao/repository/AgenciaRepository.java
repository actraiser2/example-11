package com.santalucia.example.infraestructure.dao.repository;

import java.util.List;

import com.santalucia.example.core.domain.AgenciaDomain;

public interface AgenciaRepository {

	public List<AgenciaDomain> getAgencias();

}
