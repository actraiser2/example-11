package com.santalucia.example.infrastructure.mybatis.secondary;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mybatis.dynamic.sql.SqlBuilder.select;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlMergeMode;
import org.springframework.test.context.jdbc.SqlMergeMode.MergeMode;

import com.santalucia.example.infrastructure.entity.Employee;

@MybatisTest
@SqlMergeMode(MergeMode.MERGE)
@Sql(scripts = { "/sql/schemas/employees-schema.sql" })
class EmployeesDaoMappersTests {

	@Autowired
	private EmployeeMapper employeesDaoMappers;

	@Test
	@Sql(scripts = { "/sql/data/employees-data.sql" })
	@DisplayName("Dada una query a employees se retorna un resultado")
	void getEmployeesTest() {

	    SelectStatementProvider selectStatement = select(EmployeeDynamicSqlSupport.employee.allColumns())
	            .from(EmployeeDynamicSqlSupport.employee)
	            .build()
	            .render(RenderingStrategies.MYBATIS3);

		List<Employee> employees = employeesDaoMappers.selectMany(selectStatement);
		assertThat(employees).isNotNull();
		assertThat(employees).hasSize(1);
		assertThat(employees.get(0).getFirstName()).isEqualTo("firstname");
		assertThat(employees.get(0).getLastName()).isEqualTo("lastname");
		assertThat(employees.get(0).getEmailAddress()).isEqualTo("a@a.com");
	}

}
