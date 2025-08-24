package com.santalucia.example.core.mappers;

import org.mapstruct.Mapper;

import com.santalucia.example.api.model.DocumentoResource;


@Mapper
public interface DocumentResourceMapper {

	/**
	 * @param documentResource
	 * @return
	 */
	DocumentoResource toDocumentoResource(com.santalucia.arq.ams.api.model.DocumentoResource documentResource);
}
