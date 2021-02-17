package com.santalucia.example.infrastructure.dao.repository.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.santalucia.example.core.domain.EmployeeDomain;
import com.santalucia.example.infrastructure.dao.repository.EmployeeRepository;
import com.santalucia.example.infrastructure.mybatisoracle.mappers.EmployeesDaoMappers;

@Repository
public class DefaultEmployeeRepository implements EmployeeRepository {

	private final EmployeesDaoMappers employeesDaoMappers;

	public DefaultEmployeeRepository(EmployeesDaoMappers employeesDaoMappers) {
		this.employeesDaoMappers = employeesDaoMappers;
	}

	@Override
	public List<EmployeeDomain> getAllEmployees() {
		return this.employeesDaoMappers.getEmployees();
	}

}
