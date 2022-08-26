package com.santalucia.example.core.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.santalucia.example.core.domain.EmployeeDomain;

public interface EmployeeService {

    /**
     * getEmployees
     * @return List<EmployeeDomain>
     */
	List<EmployeeDomain> getEmployees();

    /**
     * getEmployees
     * @return List<EmployeeDomain>
     */
	List<EmployeeDomain> getEmployees(Pageable pageable);

    /**
     * insertEmployee
     */
	void insertEmployee();

}
