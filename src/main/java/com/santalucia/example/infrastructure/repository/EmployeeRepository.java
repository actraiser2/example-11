package com.santalucia.example.infrastructure.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.santalucia.example.infrastructure.entity.Employee;


/**
 * EmployeeRepository
 *
 */
public interface EmployeeRepository {

    /**
     * getAllEmployees
     * @return List<Employee>
     */
	List<Employee> getAllEmployees();

    /**
     * getEmployees
     * @param Pageable pageable
     * @return List<Employee>
     */
	List<Employee> getEmployees(Pageable pageable);

    /**
     * insertEmployee
     * @param Employee employee
     */
	void insertEmployee(Employee employee);
}
