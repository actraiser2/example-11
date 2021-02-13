package com.santalucia.example.infraestructure.mybatisoracle.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;

import com.santalucia.example.core.domain.EmployeeDomain;

@Mapper
public interface EmployeesDaoMappers {

	@Select("select e.first_name, e.last_name, e.email_address from employee e")
	@Result(property = "firstName", column = "first_name")
	@Result(property = "lastName", column = "last_name")
	@Result(property = "emailAddress", column = "email_address")
	List<EmployeeDomain> getEmployees();

}
