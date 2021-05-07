package com.santalucia.example.core.mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.santalucia.example.api.model.IdentidadDigitalConsultaResource;
import com.santalucia.example.core.domain.IdentidadDigitalDomain;
import com.santalucia.example.core.domain.IdentidadDigitalDomain.IdentidadDigitalDomainBuilder;

class IdentidadDigitalDomainMapperTests {

	private static final String NOMBRE = "john"; 
	
	@Test
	@DisplayName("Dado un objeto dominio retornamos un objeto resource")
	void toApi_ok() {

		IdentidadDigitalDomainMapper mapper = new IdentidadDigitalDomainMapperImpl();

		IdentidadDigitalDomain entity = buildIdentidadDigitalDomain(NOMBRE);

		IdentidadDigitalConsultaResource dto = mapper.toResource(entity);
		compare(dto, entity);
	}
	
	@Test
	@DisplayName("Dado un objeto resource retornamos un objeto de dominio")
	void toDomain_ok() {

		IdentidadDigitalDomainMapper mapper = new IdentidadDigitalDomainMapperImpl();

		IdentidadDigitalConsultaResource dto = buildIdentidadDigitalConsultaResource(NOMBRE);

		IdentidadDigitalDomain entity = mapper.toDomain(dto);
		compare(dto, entity);
	}

	@Test
	@DisplayName("Dado una lista de objetos de dominio retornamos una lista de objetos de resource")
	void toApis_ok() {

		IdentidadDigitalDomainMapper mapper = new IdentidadDigitalDomainMapperImpl();

		IdentidadDigitalDomain entity = buildIdentidadDigitalDomain(NOMBRE);

		List<IdentidadDigitalDomain> entitys = Arrays.asList(entity);

		List<IdentidadDigitalConsultaResource> apis = mapper.toResources(entitys);

		compare(apis, entitys);
	}

	@Test
	@DisplayName("Dado una lista de objetos resource retornamos una lista de objetos de dominio")
	void toDomains_ok() {

		IdentidadDigitalDomainMapper mapper = new IdentidadDigitalDomainMapperImpl();
		IdentidadDigitalConsultaResource dto = buildIdentidadDigitalConsultaResource(NOMBRE);

		List<IdentidadDigitalConsultaResource> apis = Arrays.asList(dto);
		List<IdentidadDigitalDomain> entitys = mapper.toDomainsfromResources(apis);

		compare(apis, entitys);

	}
	
	private IdentidadDigitalConsultaResource buildIdentidadDigitalConsultaResource(String nombre) {
    	IdentidadDigitalConsultaResource response = new IdentidadDigitalConsultaResource();
    	response.setNombre(nombre);
    	response.setSaludo(String.format("Hello %s", nombre));
    	return response;
    }
	
	private IdentidadDigitalDomain buildIdentidadDigitalDomain(String nombre) {
    	IdentidadDigitalDomainBuilder identidad = IdentidadDigitalDomain.builder();
		identidad.nombre(nombre);
		identidad.saludo(String.format("Hello %s", nombre));
		return identidad.build();
    }
	
	protected void compare(List<IdentidadDigitalConsultaResource> dtos, List<IdentidadDigitalDomain> entitys) {

		assertNotNull(dtos);
		assertNotNull(entitys);

		for (int i = 0; i < dtos.size(); i++) {
			compare(dtos.get(i), entitys.get(i));
		}
	}

	protected void compare(IdentidadDigitalConsultaResource dto, IdentidadDigitalDomain entity) {
		assertNotNull(dto);
		assertNotNull(entity);
		assertEquals(entity.getNombre(), dto.getNombre());
		assertEquals(entity.getSaludo(), dto.getSaludo());
	}
}
