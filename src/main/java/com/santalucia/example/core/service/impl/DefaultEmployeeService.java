package com.santalucia.example.core.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.santalucia.example.core.domain.EmployeeDomain;
import com.santalucia.example.core.service.EmployeeService;
import com.santalucia.example.infraestructure.dao.repository.EmployeeRepository;

@Service
public class DefaultEmployeeService implements EmployeeService {

	private final EmployeeRepository employeeRepository;

	public DefaultEmployeeService(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public List<EmployeeDomain> getEmployees() {
		return this.employeeRepository.getAllEmployees();
	}

}
