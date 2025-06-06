package com.santalucia.example.infrastructure.repository.secondary;

import com.santalucia.example.infrastructure.entity.Employee;
import org.springframework.data.repository.ListPagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * EmployeePageableRepository
 *
 */
@Repository
public interface EmployeePageableRepository extends ListPagingAndSortingRepository<Employee, Long> {

}
