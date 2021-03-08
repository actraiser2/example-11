package com.santalucia.example.core.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.santalucia.example.api.model.IdentidadDigitalConsultaResource;
import com.santalucia.example.core.domain.IdentidadDigitalDomain;

@Mapper
public interface IdentidadDigitalDomainMapper {

	
	/** ONE TO ONE**/
	
	//resource <--> domain
	IdentidadDigitalConsultaResource toResource(IdentidadDigitalDomain domain);
	IdentidadDigitalDomain toDomain(IdentidadDigitalConsultaResource resource);

	
	/** MANY TO MANY**/
	
	//resources <--> domains
	List<IdentidadDigitalConsultaResource> toResources(List<IdentidadDigitalDomain> lst);
	List<IdentidadDigitalDomain> toDomainsfromResources(List<IdentidadDigitalConsultaResource> lst);



	

}
