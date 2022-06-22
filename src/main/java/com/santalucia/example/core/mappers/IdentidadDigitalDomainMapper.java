package com.santalucia.example.core.mappers;

import java.util.List;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import com.santalucia.example.api.model.IdentidadDigitalConsultaResource;
import com.santalucia.example.core.domain.IdentidadDigitalDomain;

@Mapper(injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface IdentidadDigitalDomainMapper {

	/***************/
	/** ONE TO ONE**/
	/***************/

    /**
     * toResource
     * @param IdentidadDigitalDomain domain
     * @return IdentidadDigitalConsultaResource
     */
	IdentidadDigitalConsultaResource toResource(IdentidadDigitalDomain domain);

    /**
     * toDomain
     * @param IdentidadDigitalConsultaResource resource
     * @return IdentidadDigitalDomain
     */
	IdentidadDigitalDomain toDomain(IdentidadDigitalConsultaResource resource);

	/*****************/
	/** MANY TO MANY**/
	/*****************/

    /**
     * toResources
     * @param {@code List<IdentidadDigitalDomain>}
     * @return {@code List<IdentidadDigitalConsultaResource>}
     */
	List<IdentidadDigitalConsultaResource> toResources(List<IdentidadDigitalDomain> lst);

    /**
     * toDomainsfromResources
     * @param {@code List<IdentidadDigitalConsultaResource>}
     * @return {@code List<IdentidadDigitalDomain>}
     */
	List<IdentidadDigitalDomain> toDomainsfromResources(List<IdentidadDigitalConsultaResource> lst);

}
