package com.santalucia.example.core.converters;

import org.mapstruct.Mapper;

import com.santalucia.example.api.model.Agencia;
import com.santalucia.example.core.config.ConverterConfig;
import com.santalucia.example.core.domain.AgenciaDomain;

@Mapper(config = ConverterConfig.class)
public interface AgenciaConverter {

	Agencia convertAgenciaDomainToAgencia(AgenciaDomain agenciaDomain);

}
