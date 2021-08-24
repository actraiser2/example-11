package com.santalucia.example.core.mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.santalucia.example.api.model.EmployeeResource;
import com.santalucia.example.core.domain.EmployeeDomain;

class EmployeeDomainMapperTests {

	@Test
	@DisplayName("Dado un objeto dominio retornamos un objeto resource")
	void toApi_ok() {

		EmployeeDomainMapper mapper = new EmployeeDomainMapperImpl();

		EmployeeDomain entity = buildEmployeeDomain();

		EmployeeResource dto = mapper.toResource(entity);
		compare(dto, entity);
	}

	@Test
	@DisplayName("Dado un objeto resource retornamos un objeto de dominio")
	void toDomain_ok() {

		EmployeeDomainMapper mapper = new EmployeeDomainMapperImpl();

		EmployeeResource dto = buildEmployee();

		EmployeeDomain entity = mapper.toDomain(dto);
		compare(dto, entity);
	}

	@Test
	@DisplayName("Dado una lista de objetos de dominio retornamos una lista de objetos de resource")
	void toApis_ok() {

		EmployeeDomainMapper mapper = new EmployeeDomainMapperImpl();

		EmployeeDomain entity = buildEmployeeDomain();

		List<EmployeeDomain> entitys = Arrays.asList(entity);

		List<EmployeeResource> apis = mapper.toResources(entitys);

		compare(apis, entitys);
	}

	@Test
	@DisplayName("Dado una lista de objetos resource retornamos una lista de objetos de dominio")
	void toDomains_ok() {

		EmployeeDomainMapper mapper = new EmployeeDomainMapperImpl();
		EmployeeResource dto = buildEmployee();

		List<EmployeeResource> apis = Arrays.asList(dto);
		List<EmployeeDomain> entitys = mapper.toDomainsfromResources(apis);

		compare(apis, entitys);

	}

	protected EmployeeResource buildEmployee() {

		EmployeeResource dto = new EmployeeResource();
		dto.setEmailAddress("email");
		dto.setNombre("firstName");
		dto.setApellido("lastName");
		return dto;
	}

	protected EmployeeDomain buildEmployeeDomain() {

		EmployeeDomain entity = EmployeeDomain.builder()
		.emailAddress("email")
		.firstName("firstName")
		.lastName("lastName")
		.build();
		return entity;
	}

	protected void compare(List<EmployeeResource> dtos, List<EmployeeDomain> entitys) {

		assertNotNull(dtos);
		assertNotNull(entitys);

		for (int i = 0; i < dtos.size(); i++) {
			compare(dtos.get(i), entitys.get(i));
		}
	}

	protected void compare(EmployeeResource dto, EmployeeDomain entity) {
		assertNotNull(dto);
		assertNotNull(entity);
		assertEquals(entity.getEmailAddress(), dto.getEmailAddress());
		assertEquals(entity.getFirstName(), dto.getNombre());
		assertEquals(entity.getLastName(), dto.getApellido());
	}

}
