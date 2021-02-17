package com.santalucia.example.infrastructure.dao.repository;

import java.util.List;

import com.santalucia.example.core.domain.EmployeeDomain;

public interface EmployeeRepository {

	public List<EmployeeDomain> getAllEmployees();

}
