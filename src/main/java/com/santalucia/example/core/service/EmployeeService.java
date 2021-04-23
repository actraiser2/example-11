package com.santalucia.example.core.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.santalucia.example.core.domain.EmployeeDomain;
import com.santalucia.example.infrastructure.entity.Employee;

public interface EmployeeService {

	public List<EmployeeDomain> getEmployees();
	public List<EmployeeDomain> getEmployees(Pageable pageable);
	public void insertEmployee();

}
