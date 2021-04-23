package com.santalucia.example.infrastructure.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.santalucia.example.infrastructure.entity.Employee;

public interface EmployeeRepository {

	public List<Employee> getAllEmployees();
	public List<Employee> getEmployees(Pageable pageable);
	public void insertEmployee();
}
