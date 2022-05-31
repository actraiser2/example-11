package com.santalucia.example.infrastructure.repository.impl;

import com.santalucia.example.infrastructure.entity.Employee;
import com.santalucia.example.infrastructure.mybatis.secondary.EmployeeMapper;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.verify;

@ExtendWith(SpringExtension.class)
class DefaultEmployeeRepositoryTest {

  @InjectMocks
  private DefaultEmployeeRepository repository;

  @Mock
  private EmployeeMapper employeeMapper;

  @Test
  @DisplayName("Probamos que si se llama al GetEmployees sin filtros se obtienen todos los empleados")
  void givenNoFilterParameters_whenGetAllEmployes_thenReturnAllEmployees() {
    // given
    repository.getAllEmployees();
    // when
    verify(employeeMapper).selectMany(argThat(selectStatment -> {
      // then
      assertThat("select * from employee").isEqualTo(selectStatment.getSelectStatement().toUpperCase().toLowerCase());
      Map<String, Object> parameters = selectStatment.getParameters();
      assertThat(parameters).isEmpty();
      return true;
    }));
  }

  @Test
  @DisplayName("Probamos que si se llama al GetEmployees con filtros de paginación obtienen los empleados paginados")
  void givenPageFilters_whenSelectAllEmployees_thenReturnAllEmployeesPaged() {
    // given
    repository.getEmployees(PageRequest.of(0, 10));
    // when
    verify(employeeMapper).selectMany(argThat(selectStatment -> {
      // then
      assertThat("select * from employee offset #{parameters.p1} rows fetch first #{parameters.p2} rows only").isEqualTo( selectStatment.getSelectStatement().toLowerCase());
      Map<String, Object> parameters = selectStatment.getParameters();
      assertThat(0L).isEqualTo( parameters.get("p1"));
      assertThat(10L).isEqualTo( parameters.get("p2"));
      return true;
    }));
  }

  @Test
  @DisplayName("Probamos que si se llama a InsertEmployee inserta un empleado")
  void givenANewEmployee_whenInsertAnEmployee_thenInsertsThatEmployee() {
    // given
    Employee employee = new Employee();
    employee.setFirstName("John");
    employee.setLastName("Doe");
    employee.setEmailAddress("john.doe@domain.com");
    // when
    repository.insertEmployee(employee);
    verify(employeeMapper).insert((Employee) argThat(insertEmployee -> {
      // then
      assertThat(employee).isEqualTo( insertEmployee);
      return true;
    }));
  }

}
