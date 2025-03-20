package com.santalucia.example.core.mappers;

import java.util.List;


import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.santalucia.example.api.model.EmployeeResource;
import com.santalucia.example.core.domain.EmployeeDomain;
import com.santalucia.example.infrastructure.entity.Employee;


/**
 * EmployeeDomainMapper
 *
 */
@Mapper
public interface EmployeeDomainMapper {

    /**
     * domain <--> resource
     * @param EmployeeDomain domain
     * @return EmployeeResource
     */
	@Mapping(source = "firstName", target = "nombre")
	@Mapping(source = "lastName", target = "apellido")
	EmployeeResource toResource(EmployeeDomain domain);

    /**
     * resource <--> domain
     * @param EmployeeResource resource
     * @return EmployeeDomain
     */
	@InheritInverseConfiguration
	EmployeeDomain toDomain(EmployeeResource resource);

    /**
     * entity <--> domain
     * @param Employee entity
     * @return EmployeeDomain
     */
	EmployeeDomain toDomain(Employee entity);

    /**
     * domain <--> employee
     * @param EmployeeDomain domain
     * @return Employee
     */
	Employee toEntity(EmployeeDomain domain);

    /**
     * @param List<EmployeeDomain> lst
     * @return List<EmployeeResource>
     */
	List<EmployeeResource> toResources(List<EmployeeDomain> lst);

    /**
     * @param List<EmployeeResource> lst
     * @return List<EmployeeDomain>
     */
	List<EmployeeDomain> toDomainsfromResources(List<EmployeeResource> lst);

    /**
     * @param List<Employee> lst
     * @return List<EmployeeDomain>
     */
	List<EmployeeDomain> toDomainsfromEntities(List<Employee> lst);

    /**
     * @param List<EmployeeDomain> lst
     * @return List<Employee>
     */
	List<Employee> toEntitys(List<EmployeeDomain> lst);

}
