package com.santalucia.example.infrastructure.repository.impl;

import com.santalucia.example.infrastructure.entity.Employee;
import com.santalucia.example.infrastructure.mybatis.secondary.EmployeeMapper;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.verify;

@ExtendWith(SpringExtension.class)
class DefaultEmployeeRepositoryTest {

  @InjectMocks
  private DefaultEmployeeRepository repository;

  @Mock
  private EmployeeMapper employeeMapper;

  @Test
  void getAllEmployees_ok() {
    repository.getAllEmployees();
    verify(employeeMapper).selectMany(argThat(selectStatment -> {
      assertEquals("select * from employee", selectStatment.getSelectStatement().toUpperCase().toLowerCase());
      Map<String, Object> parameters = selectStatment.getParameters();
      assertThat(parameters).isEmpty();
      return true;
    }));
  }

  @Test
  void getEmployees_ok() {
    repository.getEmployees(PageRequest.of(0, 10));
    verify(employeeMapper).selectMany(argThat(selectStatment -> {
      assertEquals("select * from employee offset #{parameters.p1} rows fetch first #{parameters.p2} rows only", selectStatment.getSelectStatement().toLowerCase());
      Map<String, Object> parameters = selectStatment.getParameters();
      assertEquals(0L, parameters.get("p1"));
      assertEquals(10L, parameters.get("p2"));
      return true;
    }));
  }

  @Test
  void insertEmployee_ok() {
    Employee employee = new Employee();
    employee.setFirstName("John");
    employee.setLastName("Doe");
    employee.setEmailAddress("john.doe@domain.com");
    repository.insertEmployee(employee);
    verify(employeeMapper).insert((Employee) argThat(insertEmployee -> {
      assertEquals(employee, insertEmployee);
      return true;
    }));
  }

}
