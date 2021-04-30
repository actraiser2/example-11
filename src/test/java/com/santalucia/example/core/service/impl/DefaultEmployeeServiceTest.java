package com.santalucia.example.core.service.impl;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.santalucia.example.core.domain.EmployeeDomain;
import com.santalucia.example.infrastructure.entity.Employee;
import com.santalucia.example.infrastructure.repository.EmployeeRepository;

@ExtendWith(SpringExtension.class)
public class DefaultEmployeeServiceTest {

	@Mock
	EmployeeRepository employeeRepository;
	
	@InjectMocks
	DefaultEmployeeService employeeService;
	
	@Test
	void test_get_employees_without_pagination() {
		
		List<Employee> listEmployeeEntity = new ArrayList<>();
		
		Employee employee1 = new Employee();
		employee1.setFirstName("John");
		employee1.setLastName("Doe");
		employee1.setEmailAddress("john@extension.com");
		
		listEmployeeEntity.add(employee1);
		
		when(employeeRepository.getAllEmployees()).thenReturn(listEmployeeEntity);
		
		List<EmployeeDomain> listResult = employeeService.getEmployees();
		
		assertNotNull(listResult);
	}
	
}
