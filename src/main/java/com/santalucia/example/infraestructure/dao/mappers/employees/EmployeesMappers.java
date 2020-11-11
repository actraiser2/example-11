package com.santalucia.example.infraestructure.dao.mappers.employees;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.santalucia.example.core.domain.EmployeeDomain;

@Mapper
public interface EmployeesMappers {

	@Select("select e.first_name, e.last_name, e.email_address from employees e;")
	List<EmployeeDomain> getEmployees();

}
