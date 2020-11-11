package com.santalucia.example.core.converters;

import org.mapstruct.Mapper;

import com.santalucia.example.api.model.Employee;
import com.santalucia.example.core.domain.EmployeeDomain;

@Mapper(componentModel = "spring")
public interface EmployeeConverter {

	Employee convertEmployeeDomainToEmployee(EmployeeDomain employeeDomain);

}
