package com.santalucia.example.core.service;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.santalucia.example.core.domain.EmployeeDomain;
import com.santalucia.example.core.mappers.EmployeeDomainMapper;
import com.santalucia.example.infrastructure.entity.Employee;
import com.santalucia.example.infrastructure.repository.EmployeeRepository;
import com.santalucia.arq.ams.componentes.database.properties.DatasourceProperties;

@Service
@Transactional(value = DatasourceProperties.SECONDARY_TRANSACTION_MANAGER)
public class DefaultEmployeeService implements EmployeeService {

	private final EmployeeRepository employeeRepository;
	private final EmployeeDomainMapper employeeMapper;

	/**
	 * Constructor de clase
	 * @param EmployeeRepository employeeRepository
	 * @param EmployeeDomainMapper employeeMapper
	 */
	public DefaultEmployeeService(EmployeeRepository employeeRepository, EmployeeDomainMapper employeeMapper) {
		this.employeeRepository = employeeRepository;
		this.employeeMapper = employeeMapper;
	}

	/**
	 * recupera los empleados
	 * @return List<EmployeeDomain>
	 */
	@Override
	public List<EmployeeDomain> getEmployees() {

		List<Employee> lstEntity = employeeRepository.getAllEmployees();
		return employeeMapper.toDomainsfromEntities(lstEntity);
	}

	/**
	 * recupera los empleados paginados
	 * @param Pageable pageable
	 * @return List<EmployeeDomain>
	 */
	@Override
	public List<EmployeeDomain> getEmployees(Pageable pageable) {
		List<Employee> employees = employeeRepository.getEmployees(pageable);
		return employeeMapper.toDomainsfromEntities(employees);
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

    this.employeeRepository.insertEmployee(emp);

    Employee empDos = Employee.builder()
    		.firstName("Juan")
    		.lastName("Lopez")
    		.emailAddress("")
    		.build();


    this.employeeRepository.insertEmployee(empDos);
	}

}
