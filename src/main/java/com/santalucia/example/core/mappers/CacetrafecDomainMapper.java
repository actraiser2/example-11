package com.santalucia.example.core.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.santalucia.example.api.model.AgenciaResource;
import com.santalucia.example.core.domain.AgenciaDomain;
import com.santalucia.example.infrastructure.entity.Cacetrafec;

@Mapper
public interface CacetrafecDomainMapper {

	/** ONE TO ONE**/
	
	//resource <--> domain
	AgenciaResource toResource(AgenciaDomain domain);
	AgenciaDomain toDomain(AgenciaResource resource);

	//domain <--> entity
	AgenciaDomain toDomain(Cacetrafec entity);
	Cacetrafec toEntity(AgenciaDomain domain);
	
	/** MANY TO MANY**/
	
	//resources <--> domains
	List<AgenciaResource> toResources(List<AgenciaDomain> lst);
	List<AgenciaDomain> toDomainsfromResources(List<AgenciaResource> lst);

	//domains <--> entitys
	List<AgenciaDomain> toDomainsfromEntities(List<Cacetrafec> lst);
	List<Cacetrafec> toEntitys(List<AgenciaDomain> lst);	

}