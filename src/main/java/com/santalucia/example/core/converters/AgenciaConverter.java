package com.santalucia.example.core.converters;

import org.mapstruct.Mapper;

import com.santalucia.example.api.model.Agencia;
import com.santalucia.example.core.domain.AgenciaDomain;

@Mapper(componentModel = "spring")
public interface AgenciaConverter {

	Agencia convertAgenciaDomainToAgencia(AgenciaDomain agenciaDomain);

}
