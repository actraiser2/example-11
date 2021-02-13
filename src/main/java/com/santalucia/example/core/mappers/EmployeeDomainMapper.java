package com.santalucia.example.core.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.santalucia.example.api.model.Employee;
import com.santalucia.example.core.domain.EmployeeDomain;

@Mapper
public interface EmployeeDomainMapper {

	Employee toApi(EmployeeDomain agenciaDomain);

	EmployeeDomain toDomain(Employee agencia);

	List<Employee> toApis(List<EmployeeDomain> agenciaDomain);

	List<EmployeeDomain> toDomains(List<Employee> agencia);

}
