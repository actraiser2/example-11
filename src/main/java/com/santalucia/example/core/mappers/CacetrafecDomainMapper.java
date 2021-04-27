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

	/***************/
	/** ONE TO ONE**/
	/***************/
	
	
    /**
     * toResource
     * @param AgenciaDomain domain
     * @return AgenciaResource
     */
	AgenciaResource toResource(AgenciaDomain domain);
	
    /**
     * toDomain
     * @param AgenciaResource resource
     * @return AgenciaDomain
     */
	AgenciaDomain toDomain(AgenciaResource resource);
	
    /**
     * indicadorDomainToResource
     * @param IndicadoresCentroDomain domain
     * @return IndicadorResource
     */
	IndicadorResource indicadorDomainToResource(IndicadoresCentroDomain domain);
	
    /**
     * indicadorResourceToDomain
     * @param IndicadorResource resource
     * @return IndicadoresCentroDomain
     */
	IndicadoresCentroDomain indicadorResourceToDomain(IndicadorResource resource);

    /**
     * toDomain
     * @param Cacetrafec entity
     * @return AgenciaDomain
     */
	AgenciaDomain toDomain(Cacetrafec entity);
	
    /**
     * toEntity
     * @param AgenciaDomain domain
     * @return Cacetrafec
     */
	Cacetrafec toEntity(AgenciaDomain domain);
	
    /**
     * cacetrafecToDomain
     * @param Cacetrafec entity
     * @return IndicadoresCentroDomain
     */
	IndicadoresCentroDomain cacetrafecToDomain(Cacetrafec entity);
	
    /**
     * indicadorDomainToEntity
     * @param IndicadoresCentroDomain domain
     * @return Cacetrafec
     */
	Cacetrafec indicadorDomainToEntity(IndicadoresCentroDomain domain);
	
	/*****************/
	/** MANY TO MANY**/
	/*****************/
	
    /**
     * toResources
     * @param List<AgenciaDomain> lst
     * @return List<AgenciaResource>
     */
	List<AgenciaResource> toResources(List<AgenciaDomain> lst);
	
    /**
     * List<AgenciaResource> lst
     * @param toDomainsfromResources
     * @return List<AgenciaDomain>
     */
	List<AgenciaDomain> toDomainsfromResources(List<AgenciaResource> lst);
	
    /**
     * indicadoresDomainToResources
     * @param List<IndicadoresCentroDomain> lst
     * @return List<IndicadorResource>
     */
	List<IndicadorResource> indicadoresDomainToResources(List<IndicadoresCentroDomain> lst);
	
    /**
     * indicadoresResourceToDomains
     * @param List<IndicadorResource> lst
     * @return List<IndicadoresCentroDomain>
     */
	List<IndicadoresCentroDomain> indicadoresResourceToDomains(List<IndicadorResource> lst);

    /**
     * toDomainsfromEntities
     * @param List<Cacetrafec> lst
     * @return List<AgenciaDomain>
     */
	List<AgenciaDomain> toDomainsfromEntities(List<Cacetrafec> lst);
	
    /**
     * toEntitys
     * @param List<AgenciaDomain> lst
     * @return List<Cacetrafec>
     */
	List<Cacetrafec> toEntitys(List<AgenciaDomain> lst);
	
    /**
     * cacetrafecEntitiestoDomains
     * @param List<Cacetrafec> lst
     * @return List<IndicadoresCentroDomain>
     */
	List<IndicadoresCentroDomain> cacetrafecEntitiestoDomains(List<Cacetrafec> lst);
	
    /**
     * indicadoresDomainToEntitys
     * @param List<IndicadoresCentroDomain> lst
     * @return List<Cacetrafec>
     */
	List<Cacetrafec> indicadoresDomainToEntitys(List<IndicadoresCentroDomain> lst);

}