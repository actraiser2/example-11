package com.santalucia.example.api.delegate;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.santalucia.example.api.model.Employee;
import com.santalucia.example.api.server.EmployeesApiDelegate;
import com.santalucia.example.core.domain.EmployeeDomain;
import com.santalucia.example.core.mappers.EmployeeDomainMapper;
import com.santalucia.example.core.service.EmployeeService;

@Component
public class DefaultEmployeesApiDelegate implements EmployeesApiDelegate {

	private final EmployeeService employeeService;

	private final EmployeeDomainMapper employeeDomainMapper;

	public DefaultEmployeesApiDelegate(EmployeeService employeeService, EmployeeDomainMapper employeeDomainMapper) {
		this.employeeService = employeeService;
		this.employeeDomainMapper = employeeDomainMapper;
	}

	@Override
	public ResponseEntity<List<Employee>> getEmployeesList(Optional<UUID> xRequestId) {

		List<EmployeeDomain> listEmployeeDomain = this.employeeService.getEmployees();
		List<Employee> listEmployee = employeeDomainMapper.toApis(listEmployeeDomain);

		return new ResponseEntity<>(listEmployee, HttpStatus.OK);
	}

}
