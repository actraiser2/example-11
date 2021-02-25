package com.santalucia.example.infrastructure.repository.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.santalucia.example.infrastructure.entity.Employee;
import com.santalucia.example.infrastructure.mybatis.secondary.EmployeeMapper;
import com.santalucia.example.infrastructure.repository.EmployeeRepository;

@Repository
public class DefaultEmployeeRepository implements EmployeeRepository {

	private final EmployeeMapper employeeMapper;

	public DefaultEmployeeRepository(EmployeeMapper employeeMapper) {
		this.employeeMapper = employeeMapper;
	}

	@Override
	public List<Employee> getAllEmployees() {
		return this.employeeMapper.select(null);
	}

}
