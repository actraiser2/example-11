package com.santalucia.example.core.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.santalucia.example.api.model.EmployeeResource;
import com.santalucia.example.core.domain.EmployeeDomain;
import com.santalucia.example.infrastructure.entity.Employee;

@Mapper
public interface EmployeeDomainMapper {

	
	/** ONE TO ONE**/
	
	//resource <--> domain
	EmployeeResource toResource(EmployeeDomain domain);
	EmployeeDomain toDomain(EmployeeResource resource);

	//domain <--> entity
	EmployeeDomain toDomain(Employee entity);
	Employee toEntity(EmployeeDomain domain);
	
	/** MANY TO MANY**/
	
	//resources <--> domains
	List<EmployeeResource> toResources(List<EmployeeDomain> lst);
	List<EmployeeDomain> toDomainsfromResources(List<EmployeeResource> lst);

	//domains <--> entitys
	List<EmployeeDomain> toDomainsfromEntities(List<Employee> lst);
	List<Employee> toEntitys(List<EmployeeDomain> lst);	

	

}
