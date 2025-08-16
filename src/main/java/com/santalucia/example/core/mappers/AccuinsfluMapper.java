package com.santalucia.example.core.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.springframework.core.convert.converter.Converter;

import com.santalucia.example.core.domain.AccuinsfluDomain;
import com.santalucia.example.infrastructure.dto.AccuinsfluDto;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AccuinsfluMapper extends Converter<AccuinsfluDomain, AccuinsfluDto>{

	public AccuinsfluDto convert(AccuinsfluDomain domain);
}
