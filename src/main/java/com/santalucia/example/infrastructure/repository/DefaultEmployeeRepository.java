package com.santalucia.example.infrastructure.repository;

import static org.mybatis.dynamic.sql.SqlBuilder.select;

import java.util.List;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.santalucia.example.infrastructure.entity.Employee;
import com.santalucia.example.infrastructure.mybatis.secondary.EmployeeDynamicSqlSupport;
import com.santalucia.example.infrastructure.mybatis.secondary.EmployeeMapper;


/**
 * DefaultEmployeeRepository
 *
 */
@Slf4j
@Repository
@AllArgsConstructor
public class DefaultEmployeeRepository implements EmployeeRepository {

	private final EmployeeMapper employeeMapper;

    /**
     * recupera todos los empleados
     * @return {@code List<Employee>}
     */
	@Override
	public List<Employee> getAllEmployees() {

	    SelectStatementProvider selectStatement = select(EmployeeDynamicSqlSupport.employee.allColumns())
	            .from(EmployeeDynamicSqlSupport.employee)
	            .build()
	            .render(RenderingStrategies.SPRING_NAMED_PARAMETER);

		return this.employeeMapper.selectMany(selectStatement);
	}

    /**
     * recupera todos los empleados paginados
     * @param Pageable pageable
     * @return {@code List<Employee>}
     */
	@Override
	public List<Employee> getEmployees(Pageable pageable) {

		log.info("Pageable pagenumber: {} ", pageable.getPageNumber());
		log.info("Pageable pageSize: {} ", pageable.getPageSize());
		log.info("Pageable offset: {} ", pageable.getOffset());

		SelectStatementProvider selectStatement = select(EmployeeDynamicSqlSupport.employee.allColumns())
	            .from(EmployeeDynamicSqlSupport.employee)
	            .offset(pageable.getOffset())
	            .fetchFirst(pageable.getPageSize()).rowsOnly()
	            .build()
	            .render(RenderingStrategies.MYBATIS3);

		return this.employeeMapper.selectMany(selectStatement);
	}

    /**
     * insterta un empleado
     * @param Employee employee
     */
	@Override
	public void insertEmployee(Employee employee) {
		this.employeeMapper.insert(employee);
	}

}
