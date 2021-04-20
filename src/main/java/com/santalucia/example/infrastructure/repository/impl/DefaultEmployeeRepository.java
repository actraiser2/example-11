package com.santalucia.example.infrastructure.repository.impl;

import static org.mybatis.dynamic.sql.SqlBuilder.select;

import java.util.List;

import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.santalucia.example.infrastructure.entity.Employee;
import com.santalucia.example.infrastructure.mybatis.secondary.EmployeeDynamicSqlSupport;
import com.santalucia.example.infrastructure.mybatis.secondary.EmployeeMapper;
import com.santalucia.example.infrastructure.repository.EmployeeRepository;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
@Transactional
public class DefaultEmployeeRepository implements EmployeeRepository {

	private final EmployeeMapper employeeMapper;

	public DefaultEmployeeRepository(EmployeeMapper employeeMapper) {
		this.employeeMapper = employeeMapper;
	}

	@Override
	public List<Employee> getAllEmployees() {

	    SelectStatementProvider selectStatement = select(EmployeeDynamicSqlSupport.employee.allColumns())
	            .from(EmployeeDynamicSqlSupport.employee)
	            .build()
	            .render(RenderingStrategies.MYBATIS3);
		
		return this.employeeMapper.selectMany(selectStatement);
	}

	@Override
	public List<Employee> getEmployees(Pageable pageable) {
		
		log.info("Pageable pagenumber: {} ", pageable.getPageNumber());
		log.info("Pageable pageSize: {} ", pageable.getPageSize());
		log.info("Pageable offset: {} ", pageable.getOffset());
		
		PageHelper.startPage(pageable.getPageNumber(), pageable.getPageSize());
		
		SelectStatementProvider selectStatement = select(EmployeeDynamicSqlSupport.employee.allColumns())
	            .from(EmployeeDynamicSqlSupport.employee)
	            .build()
	            .render(RenderingStrategies.MYBATIS3);
		
		return this.employeeMapper.selectMany(selectStatement);
	}

	@Override
	public void insertEmployee() {
		Employee emp = new Employee();
		
		emp.setFirstName("Nick");
		emp.setLastName("Jones");
		emp.setEmailAddress("nick@accenture.com");
		
		this.employeeMapper.insert(emp);
		
		Employee empDos = new Employee();
		
		empDos.setFirstName("Juan");
		empDos.setLastName("Lopez");
		empDos.setEmailAddress(null);
		
		this.employeeMapper.insert(empDos);
		
	}

}
