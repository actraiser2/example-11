package com.santalucia.example.core.service;

import java.util.List;

import com.santalucia.example.core.domain.EmployeeDomain;
import com.santalucia.example.core.mappers.EmployeeDomainMapper;
import com.santalucia.example.infrastructure.entity.Employee;
import com.santalucia.example.infrastructure.repository.secondary.EmployeePageableRepository;
import com.santalucia.example.infrastructure.repository.secondary.EmployeeRepository;
import org.instancio.Instancio;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class DefaultEmployeeServiceTests {

  @Mock
  private EmployeeRepository employeeRepository;

  @Mock
  private EmployeePageableRepository employeePageableRepository;

  @Mock
  private EmployeeDomainMapper employeeMapper;

  @InjectMocks
  private DefaultEmployeeService defaultEmployeeService;


  @Test
  @DisplayName("Recupera todos los empleados")
  void testGetAllEmployees() {

    // given
    List<Employee> employees = Instancio.createList(Employee.class);
    List<EmployeeDomain> employeeDomains = Instancio.createList(EmployeeDomain.class);

    // when
    when(employeeRepository.findAll()).thenReturn(employees);
    when(employeeMapper.toDomainsfromEntities(employees)).thenReturn(employeeDomains);
    List<EmployeeDomain> employeesResult = defaultEmployeeService.getEmployees();

    // then
    assertThat(employeesResult)
      .isNotNull()
      .containsAll(employeeDomains);
  }

  @Test
  @DisplayName("Recupera todos los empleados paginados")
  void testGetAllEmployeesPaged() {

    // given
    List<Employee> employees = Instancio.createList(Employee.class);
    Pageable pageable = Pageable.ofSize(employees.size());
    Page<Employee> result = new PageImpl<>(employees, pageable, employees.size());
    List<EmployeeDomain> employeeDomains = Instancio.createList(EmployeeDomain.class);

    // when
    when(employeePageableRepository.findAll(pageable)).thenReturn(result);
    when(employeeMapper.toDomainsfromEntities(employees)).thenReturn(employeeDomains);
    List<EmployeeDomain> employeesResult = defaultEmployeeService.getEmployees(pageable);

    // then
    assertThat(employeesResult)
      .isNotNull()
      .containsAll(employeeDomains);
  }

  @Test
  @DisplayName("Inserta dos empleados")
  void testInsertEmployees() {

    // given

    // when
    defaultEmployeeService.insertEmployee();

    // then
    verify(employeeRepository, times(2)).save(any());

  }
}
