package com.santalucia.example.infrastructure.mybatis.secondary;

import com.santalucia.example.infrastructure.entity.Employee;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.spring.boot.test.autoconfigure.AutoConfigureMybatis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlMergeMode;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mybatis.dynamic.sql.SqlBuilder.select;


@DataJdbcTest
@SqlMergeMode(SqlMergeMode.MergeMode.MERGE)
@AutoConfigureMybatis
@Sql(scripts = {"/sql/schemas/employees-schema.sql" })
class EmployeeDataTests {

  @Autowired
  private EmployeeMapper employeeMapper;

  @Test
  @Sql(scripts = { "/sql/data/employees-data.sql"  })
  @DisplayName("Test asegurando que se retornan los datos de empleados")
  void getEmployeesTestDataJDBC() {

    SelectStatementProvider selectStatement = select(EmployeeDynamicSqlSupport.employee.allColumns())
      .from(EmployeeDynamicSqlSupport.employee)
      .build()
      .render(RenderingStrategies.MYBATIS3);

    List<Employee> employees = employeeMapper.selectMany(selectStatement);

    assertThat(employees)
      .isNotNull();

    assertThat(employees.size())
      .isEqualTo(1);

    assertThat(employees.get(0).getFirstName())
      .isEqualTo("firstname");

    assertThat(employees.get(0).getLastName())
      .isEqualTo("lastname");

    assertThat(employees.get(0).getEmailAddress())
      .isEqualTo("a@a.com");

  }
}
