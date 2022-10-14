package com.santalucia.example.infrastructure.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.verify;

import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.santalucia.example.infrastructure.entity.Employee;
import com.santalucia.example.infrastructure.mybatis.secondary.EmployeeMapper;

@ExtendWith(SpringExtension.class)
class DefaultEmployeeRepositoryTests {

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
      assertThat(selectStatment.getSelectStatement().toUpperCase().toLowerCase()).isEqualTo("select * from employee");
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
      assertThat(selectStatment.getSelectStatement().toLowerCase()).isEqualTo("select * from employee offset #{parameters.p1} rows fetch first #{parameters.p2} rows only");
      Map<String, Object> parameters = selectStatment.getParameters();
      assertThat(parameters)
        .containsEntry("p1",0L)
        .containsEntry("p2",10L);
      return true;
    }));
  }

  @Test
  @DisplayName("Probamos que si se llama a InsertEmployee inserta un empleado")
  void givenANewEmployee_whenInsertAnEmployee_thenInsertsThatEmployee() {
    // given
    Employee employee = Employee.builder()
	    .firstName("John")
	    .lastName("Doe")
	    .emailAddress("john.doe@domain.com")
	    .build();
    // when
    repository.insertEmployee(employee);
    verify(employeeMapper).insert((Employee) argThat(insertEmployee -> {
      // then
      assertThat(employee).isEqualTo( insertEmployee);
      return true;
    }));
  }

}
