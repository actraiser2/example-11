package com.santalucia.example.infrastructure.mybatis.secondary;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class EmployeeDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: EMPLOYEE")
    public static final Employee employee = new Employee();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: EMPLOYEE.FIRST_NAME")
    public static final SqlColumn<String> firstName = employee.firstName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: EMPLOYEE.LAST_NAME")
    public static final SqlColumn<String> lastName = employee.lastName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: EMPLOYEE.EMAIL_ADDRESS")
    public static final SqlColumn<String> emailAddress = employee.emailAddress;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: EMPLOYEE")
    public static final class Employee extends AliasableSqlTable<Employee> {
        public final SqlColumn<String> firstName = column("FIRST_NAME", JDBCType.VARCHAR);

        public final SqlColumn<String> lastName = column("LAST_NAME", JDBCType.VARCHAR);

        public final SqlColumn<String> emailAddress = column("EMAIL_ADDRESS", JDBCType.VARCHAR);

        public Employee() {
            super("EMPLOYEE", Employee::new);
        }
    }
}
