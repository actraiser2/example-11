package com.santalucia.example.core.mappers;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.instancio.Instancio;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.santalucia.example.api.model.IdentidadDigitalConsultaResource;
import com.santalucia.example.core.domain.IdentidadDigitalDomain;

class IdentidadDigitalDomainMapperTests {

	@Test
	@DisplayName("Dado un objeto dominio retornamos un objeto resource")
	void toApi_ok() {

		IdentidadDigitalDomainMapper mapper = new IdentidadDigitalDomainMapperImpl();

		IdentidadDigitalDomain entity = Instancio.create(IdentidadDigitalDomain.class);

		IdentidadDigitalConsultaResource dto = mapper.toResource(entity);
		compare(dto, entity);
	}

	@Test
	@DisplayName("Dado un objeto resource retornamos un objeto de dominio")
	void toDomain_ok() {

		IdentidadDigitalDomainMapper mapper = new IdentidadDigitalDomainMapperImpl();

		IdentidadDigitalConsultaResource dto = Instancio.create(IdentidadDigitalConsultaResource.class);

		IdentidadDigitalDomain entity = mapper.toDomain(dto);
		compare(dto, entity);
	}

	@Test
	@DisplayName("Dado una lista de objetos de dominio retornamos una lista de objetos de resource")
	void toApis_ok() {

		IdentidadDigitalDomainMapper mapper = new IdentidadDigitalDomainMapperImpl();

		List<IdentidadDigitalDomain> entitys = Instancio.createList(IdentidadDigitalDomain.class);

		List<IdentidadDigitalConsultaResource> apis = mapper.toResources(entitys);

		compare(apis, entitys);
	}

	@Test
	@DisplayName("Dado una lista de objetos resource retornamos una lista de objetos de dominio")
	void toDomains_ok() {

		IdentidadDigitalDomainMapper mapper = new IdentidadDigitalDomainMapperImpl();

		List<IdentidadDigitalConsultaResource> apis = Instancio.createList(IdentidadDigitalConsultaResource.class);
		List<IdentidadDigitalDomain> entitys = mapper.toDomainsfromResources(apis);

		compare(apis, entitys);

	}

	protected void compare(List<IdentidadDigitalConsultaResource> dtos, List<IdentidadDigitalDomain> entitys) {

		assertThat(dtos).isNotNull();
		assertThat(entitys).isNotNull();

		for (int i = 0; i < dtos.size(); i++) {
			compare(dtos.get(i), entitys.get(i));
		}
	}

	protected void compare(IdentidadDigitalConsultaResource dto, IdentidadDigitalDomain entity) {
		assertThat(dto).isNotNull();
		assertThat(entity).isNotNull();
		assertThat(dto.getNombre()).isEqualTo(entity.getNombre());
		assertThat(dto.getSaludo()).isEqualTo(entity.getSaludo());
	}
}
