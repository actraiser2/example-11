package com.santalucia.example.core.mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.santalucia.example.api.model.Employee;
import com.santalucia.example.core.domain.EmployeeDomain;

class EmployeeDomainMapperTests {

	@Test
	void toApi_ok() {

		EmployeeDomainMapper mapper = new EmployeeDomainMapperImpl();

		EmployeeDomain entity = buildEmployeeDomain();

		Employee dto = mapper.toApi(entity);
		compare(dto, entity);
	}

	@Test
	void toDomain_ok() {

		EmployeeDomainMapper mapper = new EmployeeDomainMapperImpl();

		Employee dto = buildEmployee();

		EmployeeDomain entity = mapper.toDomain(dto);
		compare(dto, entity);
	}

	@Test
	void toApis_ok() {

		EmployeeDomainMapper mapper = new EmployeeDomainMapperImpl();

		EmployeeDomain entity = buildEmployeeDomain();

		List<EmployeeDomain> entitys = Arrays.asList(entity);

		List<Employee> apis = mapper.toApis(entitys);

		compare(apis, entitys);
	}

	@Test
	void toDomains_ok() {

		EmployeeDomainMapper mapper = new EmployeeDomainMapperImpl();
		Employee dto = buildEmployee();

		List<Employee> apis = Arrays.asList(dto);
		List<EmployeeDomain> entitys = mapper.toDomains(apis);

		compare(apis, entitys);

	}

	protected Employee buildEmployee() {

		Employee dto = new Employee();
		dto.setEmailAddress("email");
		dto.setFirstName("firstName");
		dto.setLastName("lastName");
		return dto;
	}

	protected EmployeeDomain buildEmployeeDomain() {

		EmployeeDomain entity = new EmployeeDomain();
		entity.setEmailAddress("email");
		entity.setFirstName("firstName");
		entity.setLastName("lastName");
		return entity;
	}

	protected void compare(List<Employee> dtos, List<EmployeeDomain> entitys) {

		assertNotNull(dtos);
		assertNotNull(entitys);

		for (int i = 0; i < dtos.size(); i++) {
			compare(dtos.get(i), entitys.get(i));
		}
	}

	protected void compare(Employee dto, EmployeeDomain entity) {
		assertNotNull(dto);
		assertNotNull(entity);
		assertEquals(entity.getEmailAddress(), dto.getEmailAddress());
		assertEquals(entity.getFirstName(), dto.getFirstName());
		assertEquals(entity.getLastName(), dto.getLastName());
	}

}
