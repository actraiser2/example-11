package com.santalucia.example.infrastructure.repository.secondary;

import com.santalucia.example.infrastructure.entity.Employee;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

/**
 * EmployeeRepository
 *
 */
@Repository
public interface EmployeeRepository extends ListCrudRepository<Employee, Long> {

}
