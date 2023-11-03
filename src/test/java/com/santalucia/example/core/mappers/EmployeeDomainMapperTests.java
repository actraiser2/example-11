package com.santalucia.example.core.mappers;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.instancio.Instancio;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.santalucia.example.api.model.EmployeeResource;
import com.santalucia.example.core.domain.EmployeeDomain;

class EmployeeDomainMapperTests {

	@Test
	@DisplayName("Dado un objeto dominio retornamos un objeto resource")
	void toApi_ok() {

		EmployeeDomainMapper mapper = new EmployeeDomainMapperImpl();

		EmployeeDomain entity = Instancio.create(EmployeeDomain.class);

		EmployeeResource dto = mapper.toResource(entity);
		compare(dto, entity);
	}

	@Test
	@DisplayName("Dado un objeto resource retornamos un objeto de dominio")
	void toDomain_ok() {

		EmployeeDomainMapper mapper = new EmployeeDomainMapperImpl();

		EmployeeResource dto = Instancio.create(EmployeeResource.class);

		EmployeeDomain entity = mapper.toDomain(dto);
		compare(dto, entity);
	}

	@Test
	@DisplayName("Dado una lista de objetos de dominio retornamos una lista de objetos de resource")
	void toApis_ok() {

		EmployeeDomainMapper mapper = new EmployeeDomainMapperImpl();

		List<EmployeeDomain> entitys = Instancio.createList(EmployeeDomain.class);

		List<EmployeeResource> apis = mapper.toResources(entitys);

		compare(apis, entitys);
	}

	@Test
	@DisplayName("Dado una lista de objetos resource retornamos una lista de objetos de dominio")
	void toDomains_ok() {

		EmployeeDomainMapper mapper = new EmployeeDomainMapperImpl();
		List<EmployeeResource> apis = Instancio.createList(EmployeeResource.class);
		List<EmployeeDomain> entitys = mapper.toDomainsfromResources(apis);

		compare(apis, entitys);

	}

	protected void compare(List<EmployeeResource> dtos, List<EmployeeDomain> entitys) {

		assertThat(dtos).isNotNull();
		assertThat(entitys).isNotNull();

		for (int i = 0; i < dtos.size(); i++) {
			compare(dtos.get(i), entitys.get(i));
		}
	}

	protected void compare(EmployeeResource dto, EmployeeDomain entity) {
		assertThat(dto).isNotNull();
		assertThat(entity).isNotNull();
		assertThat(dto.getEmailAddress()).isEqualTo(entity.getEmailAddress());
		assertThat(dto.getNombre()).isEqualTo(entity.getFirstName());
		assertThat(dto.getApellido()).isEqualTo(entity.getLastName());
	}

}
