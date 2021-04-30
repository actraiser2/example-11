package com.santalucia.example.core.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.santalucia.example.core.domain.EmployeeDomain;
import com.santalucia.example.core.mappers.EmployeeDomainMapper;
import com.santalucia.example.infrastructure.entity.Employee;
import com.santalucia.example.infrastructure.repository.EmployeeRepository;

@ExtendWith(SpringExtension.class)
class DefaultEmployeeServiceTest {
	
	private static final String FIRST_NAME = "John";
	private static final String LAST_NAME = "Doe";

	@Mock
	EmployeeRepository employeeRepository;
	
	@Mock
	EmployeeDomainMapper employeeMapper;
	
	@InjectMocks
	DefaultEmployeeService employeeService;
	
	@Test
	void test_get_employees_without_pagination() {
		
		when(employeeRepository.getAllEmployees()).thenReturn(getListEmployeeEntity());
		when(employeeMapper.toDomainsfromEntities(Mockito.anyList())).thenReturn(getListEmployeeDomain());
		
		List<EmployeeDomain> listResult = employeeService.getEmployees();
		
		assertNotNull(listResult);
		
		EmployeeDomain employeeDomain = listResult.get(0);
		assertEquals(FIRST_NAME, employeeDomain.getFirstName());
		assertEquals(LAST_NAME, employeeDomain.getLastName());
		assertEquals("john@domain.com", employeeDomain.getEmailAddress());
	}
	
	private List<Employee> getListEmployeeEntity() {
		
		return Arrays.asList(buildEmployeeTest(FIRST_NAME, LAST_NAME));
	}
	
	private List<EmployeeDomain> getListEmployeeDomain() {
		
		return Arrays.asList(buildEmployeeDomainTest(FIRST_NAME, LAST_NAME));
	}
	
	private Employee buildEmployeeTest(String firstName, String lastName) {
		
		Employee employee = new Employee();
		employee.setFirstName(firstName);
		employee.setLastName(lastName);
		employee.setEmailAddress(buildEmailAdressTest(firstName));
		return employee;
	}
	
	private EmployeeDomain buildEmployeeDomainTest(String firstName, String lastName) {
		
		return EmployeeDomain.builder()
				.firstName(firstName)
				.lastName(lastName)
				.emailAddress(buildEmailAdressTest(firstName))
				.build();
	}
	
	private String buildEmailAdressTest(String firstName) {
		StringBuilder sb = new StringBuilder();
		sb.append(firstName.toLowerCase());
		sb.append("@domain.com");
		return sb.toString();
	}
}
