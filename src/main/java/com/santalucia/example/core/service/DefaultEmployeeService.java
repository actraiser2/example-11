package com.santalucia.example.core.service;

import java.util.List;


import com.santalucia.arq.ams.data.jdbc.constants.DatasourceConstants;
import com.santalucia.example.infrastructure.repository.secondary.EmployeePageableRepository;
import com.santalucia.example.infrastructure.repository.secondary.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.santalucia.example.core.domain.EmployeeDomain;
import com.santalucia.example.core.mappers.EmployeeDomainMapper;
import com.santalucia.example.infrastructure.entity.Employee;


/**
 * DefaultEmployeeService
 *
 */
@Service
@AllArgsConstructor
@Transactional(value = DatasourceConstants.SECONDARY_TRANSACTION_MANAGER)
public class DefaultEmployeeService implements EmployeeService {

	private final EmployeeRepository employeeRepository;
  private final EmployeePageableRepository employeePageableRepository;
	private final EmployeeDomainMapper employeeMapper;

	/**
	 * recupera los empleados
	 * @return List<EmployeeDomain>
	 */
	@Override
	public List<EmployeeDomain> getEmployees() {
		List<Employee> lstEntity = employeeRepository.findAll();
		return employeeMapper.toDomainsfromEntities(lstEntity);
	}

	/**
	 * recupera los empleados paginados
	 * @param pageable Pageable
	 * @return List<EmployeeDomain>
	 */
	@Override
	public List<EmployeeDomain> getEmployees(Pageable pageable) {
		Page<Employee> employees = employeePageableRepository.findAll(pageable);
		return employeeMapper.toDomainsfromEntities(employees.stream().toList());
	}

	/**
	 * inserta un empleado
	 */
	@Override
	public void insertEmployee() {
    Employee emp = Employee.builder()
    		.firstName("Julie")
    		.lastName("Pearson")
    		.emailAddress("julie@accenture.com")
    		.build();

    employeeRepository.save(emp);

    Employee empDos = Employee.builder()
    		.firstName("Juan")
    		.lastName("Lopez")
    		.emailAddress("juan@email.com")
    		.build();


    employeeRepository.save(empDos);
	}

}
