package com.santalucia.example.api.delegate;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.santalucia.example.api.model.EmployeeResource;
import com.santalucia.example.api.server.EmployeesApiDelegate;
import com.santalucia.example.core.mappers.EmployeeDomainMapper;
import com.santalucia.example.core.service.EmployeeService;

@Component
public class DefaultEmployeesApiDelegate implements EmployeesApiDelegate {

	private final EmployeeService employeeService;
	private final EmployeeDomainMapper employeeMapper;


	public DefaultEmployeesApiDelegate(EmployeeService employeeService, EmployeeDomainMapper employeeMapper) {
		this.employeeService = employeeService;
		this.employeeMapper = employeeMapper;
	}


	@Override
	public ResponseEntity<List<EmployeeResource>> getEmployeesList(Optional<UUID> xRequestId) {
		
		return Optional
				.ofNullable(employeeService.getEmployees())
				.map(employees -> ResponseEntity.ok().body(employeeMapper.toResources(employees))) // 200 OK
				.orElse(ResponseEntity.notFound().build()); // 404 Not found
	}
}
