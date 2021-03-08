package com.santalucia.example.infrastructure.repository.impl;

import static org.mybatis.dynamic.sql.SqlBuilder.select;

import java.util.List;

import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.stereotype.Repository;

import com.santalucia.example.infrastructure.entity.Employee;
import com.santalucia.example.infrastructure.mybatis.secondary.EmployeeDynamicSqlSupport;
import com.santalucia.example.infrastructure.mybatis.secondary.EmployeeMapper;
import com.santalucia.example.infrastructure.repository.EmployeeRepository;

@Repository
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

}
