package com.santalucia.example.core.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.santalucia.example.api.model.AgenciaResource;
import com.santalucia.example.api.model.IndicadorResource;
import com.santalucia.example.core.domain.AgenciaDomain;
import com.santalucia.example.core.domain.IndicadoresCentroDomain;
import com.santalucia.example.infrastructure.entity.Cacetrafec;

@Mapper
public interface CacetrafecDomainMapper {

	/** ONE TO ONE**/
	
	//resource <--> domain
	AgenciaResource toResource(AgenciaDomain domain);
	AgenciaDomain toDomain(AgenciaResource resource);
	
	IndicadorResource indicadorDomainToResource(IndicadoresCentroDomain domain);
	IndicadoresCentroDomain indicadorResourceToDomain(IndicadorResource resource);

	//domain <--> entity
	AgenciaDomain toDomain(Cacetrafec entity);
	Cacetrafec toEntity(AgenciaDomain domain);
	
	IndicadoresCentroDomain cacetrafecToDomain(Cacetrafec entity);
	Cacetrafec indicadorDomainToEntity(IndicadoresCentroDomain domain);
	
	/** MANY TO MANY**/
	
	//resources <--> domains
	List<AgenciaResource> toResources(List<AgenciaDomain> lst);
	List<AgenciaDomain> toDomainsfromResources(List<AgenciaResource> lst);
	
	List<IndicadorResource> indicadoresDomainToResources(List<IndicadoresCentroDomain> lst);
	List<IndicadoresCentroDomain> indicadoresResourceToDomains(List<IndicadorResource> lst);

	//domains <--> entitys
	List<AgenciaDomain> toDomainsfromEntities(List<Cacetrafec> lst);
	List<Cacetrafec> toEntitys(List<AgenciaDomain> lst);
	
	List<IndicadoresCentroDomain> cacetrafecEntitiestoDomains(List<Cacetrafec> lst);
	List<Cacetrafec> indicadoresDomainToEntitys(List<IndicadoresCentroDomain> lst);

}