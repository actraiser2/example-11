package com.santalucia.example.infrastructure.repository;

import java.util.List;

import com.santalucia.example.infrastructure.entity.Employee;

public interface EmployeeRepository {

	public List<Employee> getAllEmployees();

}
