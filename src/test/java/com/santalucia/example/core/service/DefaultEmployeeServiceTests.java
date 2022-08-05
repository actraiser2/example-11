package com.santalucia.example.core.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
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
class DefaultEmployeeServiceTests {

	private static final String FIRST_NAME = "John";
	private static final String LAST_NAME = "Doe";

	@Mock
	EmployeeRepository employeeRepository;

	@Mock
	EmployeeDomainMapper employeeMapper;

	@InjectMocks
	DefaultEmployeeService employeeService;

	@Test
	@DisplayName("dada una busqueda a getEmployees sin paginacion el resultado es correcto")
	void test_get_employees_without_pagination() {

		when(employeeRepository.getAllEmployees()).thenReturn(getListEmployeeEntity());
		when(employeeMapper.toDomainsfromEntities(Mockito.anyList())).thenReturn(getListEmployeeDomain());

		List<EmployeeDomain> listResult = employeeService.getEmployees();

		assertThat(listResult).isNotNull();

		EmployeeDomain employeeDomain = listResult.get(0);
		assertThat(employeeDomain.getFirstName()).isEqualTo(FIRST_NAME);
		assertThat(employeeDomain.getLastName()).isEqualTo(LAST_NAME);
		assertThat(employeeDomain.getEmailAddress()).isEqualTo("john@domain.com");
	}

	private List<Employee> getListEmployeeEntity() {

		return Arrays.asList(buildEmployeeTest(FIRST_NAME, LAST_NAME));
	}

	private List<EmployeeDomain> getListEmployeeDomain() {

		return Arrays.asList(buildEmployeeDomainTest(FIRST_NAME, LAST_NAME));
	}

	private Employee buildEmployeeTest(String firstName, String lastName) {

		Employee employee = Employee.builder()
		.firstName(firstName)
		.lastName(lastName)
		.emailAddress(buildEmailAdressTest(firstName))
		.build();
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
