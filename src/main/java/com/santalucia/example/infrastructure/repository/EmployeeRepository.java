package com.santalucia.example.infrastructure.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.santalucia.example.infrastructure.entity.Employee;

public interface EmployeeRepository {

    /**
     * getAllEmployees
     * @return List<Employee>
     */
	public List<Employee> getAllEmployees();

    /**
     * getEmployees
     * @param Pageable pageable
     * @return List<Employee>
     */
	public List<Employee> getEmployees(Pageable pageable);

    /**
     * insertEmployee
     */
	public void insertEmployee();
}
