package com.santalucia.example.core.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.List;

import org.instancio.Instancio;
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

	@Mock
	EmployeeRepository employeeRepository;

	@Mock
	EmployeeDomainMapper employeeMapper;

	@InjectMocks
	DefaultEmployeeService employeeService;

	@Test
	@DisplayName("dada una busqueda a getEmployees sin paginacion el resultado es correcto")
	void test_get_employees_without_pagination() {
		
	    List<Employee> employees = Instancio.createList(Employee.class);
	    List<EmployeeDomain> employeeDomains = Instancio.createList(EmployeeDomain.class);

		 List<Employee> employees = Instancio.createList(Employee.class);
		 List<EmployeeDomain> employeeDomains = Instancio.createList(EmployeeDomain.class);
		    
		    
		when(employeeRepository.getAllEmployees()).thenReturn(employees);
		when(employeeMapper.toDomainsfromEntities(Mockito.anyList())).thenReturn(employeeDomains);

		List<EmployeeDomain> listResult = employeeService.getEmployees();

		assertThat(listResult)
		.isNotNull()
		.containsAll(employeeDomains);
	}
}
