package com.santalucia.example.api.delegate;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.santalucia.example.api.model.EmployeeResource;
import com.santalucia.example.api.server.EmployeesApiDelegate;
import com.santalucia.example.core.mappers.EmployeeDomainMapper;
import com.santalucia.example.core.service.EmployeeService;

@Component
public class DefaultEmployeesApiDelegate implements EmployeesApiDelegate {

	private final EmployeeService employeeService;


	public DefaultEmployeesApiDelegate(EmployeeService employeeService, EmployeeDomainMapper employeeDomainMapper) {
		this.employeeService = employeeService;
	}

	@Override
	public ResponseEntity<List<EmployeeResource>> getEmployeesList(Optional<UUID> xRequestId) {
		return new ResponseEntity<>(this.employeeService.getEmployees(), HttpStatus.OK);
	}

}
