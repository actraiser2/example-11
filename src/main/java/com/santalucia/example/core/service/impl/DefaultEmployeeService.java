package com.santalucia.example.core.service.impl;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.santalucia.example.core.domain.EmployeeDomain;
import com.santalucia.example.core.mappers.EmployeeDomainMapper;
import com.santalucia.example.core.service.EmployeeService;
import com.santalucia.example.infrastructure.entity.Employee;
import com.santalucia.example.infrastructure.repository.EmployeeRepository;

@Service
public class DefaultEmployeeService implements EmployeeService {

	private final EmployeeRepository employeeRepository;
	private final EmployeeDomainMapper employeeMapper;

	public DefaultEmployeeService(EmployeeRepository employeeRepository, EmployeeDomainMapper employeeMapper) {
		this.employeeRepository = employeeRepository;
		this.employeeMapper = employeeMapper;
	}

	@Override
	public List<EmployeeDomain> getEmployees() {
		
		List<Employee> lstEntity = employeeRepository.getAllEmployees();
		return employeeMapper.toDomainsfromEntities(lstEntity);
	}

	@Override
	public List<EmployeeDomain> getEmployees(Pageable pageable) {
		List<Employee> employees = employeeRepository.getEmployees(pageable);
		return employeeMapper.toDomainsfromEntities(employees);
	}

	@Override
	public void insertEmployee() {		
		
		this.employeeRepository.insertEmployee();
	}

}
