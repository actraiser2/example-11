package com.santalucia.example.core.mappers;

import java.util.List;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import com.santalucia.example.api.model.IndicadorResource;
import com.santalucia.example.core.domain.IndicadoresCentroDomain;
import com.santalucia.example.infrastructure.entity.Cacetrafec;


/**
 *  CacetrafecDomainMapper
 *
 */
@Mapper(injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface CacetrafecDomainMapper {

	/***************/
	/** ONE TO ONE**/
	/***************/


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
