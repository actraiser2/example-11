package com.santalucia.example.api.delegate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.santalucia.example.api.model.Employee;
import com.santalucia.example.api.web.EmployeesApiDelegate;
import com.santalucia.example.core.converters.EmployeeConverter;
import com.santalucia.example.core.domain.EmployeeDomain;
import com.santalucia.example.core.service.EmployeeService;

@Component
public class DefaultEmployeesApiDelegate implements EmployeesApiDelegate {

	private final EmployeeService employeeService;

	private final EmployeeConverter employeeConverter;

	public DefaultEmployeesApiDelegate(EmployeeService employeeService, EmployeeConverter employeeConverter) {
		this.employeeService = employeeService;
		this.employeeConverter = employeeConverter;
	}

	@Override
	public ResponseEntity<List<Employee>> getEmployeesList(Optional<UUID> xRequestId) {
		List<Employee> listEmployee = new ArrayList<>();

		List<EmployeeDomain> listEmployeeDomain = this.employeeService.getEmployees();
		listEmployeeDomain.forEach((employeeDomain) -> {
			Employee employee = this.employeeConverter.convertEmployeeDomainToEmployee(employeeDomain);
			listEmployee.add(employee);
		});

		return new ResponseEntity<List<Employee>>(listEmployee, HttpStatus.OK);
	}

}
