package com.santalucia.example.infraestructure.dao.repository.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.santalucia.example.core.domain.EmployeeDomain;
import com.santalucia.example.infraestructure.dao.mappers.employees.EmployeesMappers;
import com.santalucia.example.infraestructure.dao.repository.EmployeeRepository;

@Repository
public class DefaultEmployeeRepository implements EmployeeRepository {

	private final EmployeesMappers employeesMappers;

	public DefaultEmployeeRepository(EmployeesMappers employeesMappers) {
		this.employeesMappers = employeesMappers;
	}

	@Override
	public List<EmployeeDomain> getAllEmployees() {
		return this.employeesMappers.getEmployees();
	}

}
