package com.santalucia.example.core.converters;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import com.santalucia.example.api.model.Employee;
import com.santalucia.example.core.domain.EmployeeDomain;

class EmployeeConverterTests {

	@Test
	void mapping_ok() {

		EmployeeConverter mapper = new EmployeeConverterImpl();

		EmployeeDomain jpa = new EmployeeDomain();
		jpa.setEmailAddress("a");
		jpa.setFirstName("b");
		jpa.setLastName("v");

		Employee dto = mapper.convertEmployeeDomainToEmployee(jpa);

		compare(dto, jpa);

	}

	protected void compare(Employee dto, EmployeeDomain jpa) {
		assertNotNull(dto);
		assertNotNull(jpa);

		assertEquals(jpa.getEmailAddress(), dto.getEmailAddress());
		assertEquals(jpa.getFirstName(), dto.getFirstName());
		assertEquals(jpa.getLastName(), dto.getLastName());

	}

}
