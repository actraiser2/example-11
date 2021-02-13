package com.santalucia.example.core.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.santalucia.example.api.model.Agencia;
import com.santalucia.example.core.domain.AgenciaDomain;

@Mapper
public interface AgenciaDomainMapper {

	Agencia toApi(AgenciaDomain agenciaDomain);

	AgenciaDomain toDomain(Agencia agencia);

	List<Agencia> toApis(List<AgenciaDomain> agenciaDomain);

	List<AgenciaDomain> toDomains(List<Agencia> agencia);

}