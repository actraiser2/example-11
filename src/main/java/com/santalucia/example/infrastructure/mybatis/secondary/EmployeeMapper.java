package com.santalucia.example.infrastructure.mybatis.secondary;

import static com.santalucia.example.infrastructure.mybatis.secondary.EmployeeDynamicSqlSupport.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import jakarta.annotation.Generated;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.delete.DeleteDSLCompleter;
import org.mybatis.dynamic.sql.select.CountDSLCompleter;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.UpdateDSL;
import org.mybatis.dynamic.sql.update.UpdateDSLCompleter;
import org.mybatis.dynamic.sql.update.UpdateModel;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
import org.mybatis.dynamic.sql.util.mybatis3.CommonCountMapper;
import org.mybatis.dynamic.sql.util.mybatis3.CommonDeleteMapper;
import org.mybatis.dynamic.sql.util.mybatis3.CommonInsertMapper;
import org.mybatis.dynamic.sql.util.mybatis3.CommonUpdateMapper;
import org.mybatis.dynamic.sql.util.mybatis3.MyBatis3Utils;

import com.santalucia.example.infrastructure.entity.Employee;

@Mapper
public interface EmployeeMapper extends CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<Employee>, CommonUpdateMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: EMPLOYEE")
    BasicColumn[] selectList = BasicColumn.columnList(firstName, lastName, emailAddress);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: EMPLOYEE")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="EmployeeResult", value = {
        @Result(column="FIRST_NAME", property="firstName", jdbcType=JdbcType.VARCHAR),
        @Result(column="LAST_NAME", property="lastName", jdbcType=JdbcType.VARCHAR),
        @Result(column="EMAIL_ADDRESS", property="emailAddress", jdbcType=JdbcType.VARCHAR)
    })
    List<Employee> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: EMPLOYEE")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("EmployeeResult")
    Optional<Employee> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: EMPLOYEE")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, employee, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: EMPLOYEE")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, employee, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: EMPLOYEE")
    default int insert(Employee row) {
        return MyBatis3Utils.insert(this::insert, row, employee, c ->
            c.map(firstName).toProperty("firstName")
            .map(lastName).toProperty("lastName")
            .map(emailAddress).toProperty("emailAddress")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: EMPLOYEE")
    default int insertMultiple(Collection<Employee> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, employee, c ->
            c.map(firstName).toProperty("firstName")
            .map(lastName).toProperty("lastName")
            .map(emailAddress).toProperty("emailAddress")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: EMPLOYEE")
    default int insertSelective(Employee row) {
        return MyBatis3Utils.insert(this::insert, row, employee, c ->
            c.map(firstName).toPropertyWhenPresent("firstName", row::getFirstName)
            .map(lastName).toPropertyWhenPresent("lastName", row::getLastName)
            .map(emailAddress).toPropertyWhenPresent("emailAddress", row::getEmailAddress)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: EMPLOYEE")
    default Optional<Employee> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, employee, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: EMPLOYEE")
    default List<Employee> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, employee, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: EMPLOYEE")
    default List<Employee> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, employee, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: EMPLOYEE")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, employee, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: EMPLOYEE")
    static UpdateDSL<UpdateModel> updateAllColumns(Employee row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(firstName).equalTo(row::getFirstName)
                .set(lastName).equalTo(row::getLastName)
                .set(emailAddress).equalTo(row::getEmailAddress);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: EMPLOYEE")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Employee row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(firstName).equalToWhenPresent(row::getFirstName)
                .set(lastName).equalToWhenPresent(row::getLastName)
                .set(emailAddress).equalToWhenPresent(row::getEmailAddress);
    }
}
