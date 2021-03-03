package com.santalucia.example.core.mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.santalucia.example.api.model.AgenciaResource;
import com.santalucia.example.core.domain.AgenciaDomain;

class CacetrafecDomainMapperTests {

	@Test
	@DisplayName("I'm a Test Class") // TODO: EXTENDER
	void toApi_ok() {

		CacetrafecDomainMapper mapper = new CacetrafecDomainMapperImpl();
		AgenciaDomain entity = buildAgenciDomain();
		AgenciaResource dto = mapper.toResource(entity);

		compare(dto, entity);
	}

	@Test
	void toDomain_ok() {

		CacetrafecDomainMapper mapper = new CacetrafecDomainMapperImpl();
		AgenciaResource dto = buildAgencia();
		AgenciaDomain entity = mapper.toDomain(dto);

		compare(dto, entity);
	}

	@Test
	void toApis_ok() {

		CacetrafecDomainMapper mapper = new CacetrafecDomainMapperImpl();
		AgenciaDomain entity = buildAgenciDomain();
		List<AgenciaDomain> entitys = Arrays.asList(entity);
		List<AgenciaResource> apis = mapper.toResources(entitys);

		compare(apis, entitys);
	}

	@Test
	void toDomains_ok() {

		CacetrafecDomainMapper mapper = new CacetrafecDomainMapperImpl();
		AgenciaResource dto = buildAgencia();

		List<AgenciaResource> apis = Arrays.asList(dto);
		List<AgenciaDomain> entitys = mapper.toDomainsfromResources(apis);

		compare(apis, entitys);
	}

	protected AgenciaResource buildAgencia() {

		AgenciaResource dto = new AgenciaResource();
		dto.setDagencia("email");
		dto.setDdomici("firstName");
		dto.setDpoblaci("lastName");
		dto.setDprov("lastName");
		dto.setDtvia("lastName");
		return dto;
	}

	protected AgenciaDomain buildAgenciDomain() {

		AgenciaDomain entity = new AgenciaDomain();
		entity.setDagencia("email");
		entity.setDdomici("firstName");
		entity.setDpoblaci("lastName");
		entity.setDprov("lastName");
		entity.setDtvia("lastName");
		return entity;
	}

	protected void compare(List<AgenciaResource> dtos, List<AgenciaDomain> entitys) {

		assertNotNull(dtos);
		assertNotNull(entitys);

		for (int i = 0; i < dtos.size(); i++) {
			compare(dtos.get(i), entitys.get(i));
		}
	}

	protected void compare(AgenciaResource dto, AgenciaDomain entity) {
		assertNotNull(dto);
		assertNotNull(entity);
		assertEquals(entity.getDagencia(), dto.getDagencia());
		assertEquals(entity.getDdomici(), dto.getDdomici());
		assertEquals(entity.getDpoblaci(), dto.getDpoblaci());
		assertEquals(entity.getDprov(), dto.getDprov());
		assertEquals(entity.getDtvia(), dto.getDtvia());
	}

}
