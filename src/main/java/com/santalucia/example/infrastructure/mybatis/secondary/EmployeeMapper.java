package com.santalucia.example.infrastructure.mybatis.secondary;

import static com.santalucia.example.infrastructure.mybatis.secondary.EmployeeDynamicSqlSupport.*;

import com.santalucia.example.infrastructure.entity.Employee;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import javax.annotation.Generated;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.delete.DeleteDSLCompleter;
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider;
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider;
import org.mybatis.dynamic.sql.insert.render.MultiRowInsertStatementProvider;
import org.mybatis.dynamic.sql.select.CountDSLCompleter;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.UpdateDSL;
import org.mybatis.dynamic.sql.update.UpdateDSLCompleter;
import org.mybatis.dynamic.sql.update.UpdateModel;
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
import org.mybatis.dynamic.sql.util.mybatis3.MyBatis3Utils;

@Mapper
public interface EmployeeMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: EMPLOYEE")
    BasicColumn[] selectList = BasicColumn.columnList(firstName, lastName, emailAddress);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: EMPLOYEE")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: EMPLOYEE")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: EMPLOYEE")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<Employee> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: EMPLOYEE")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<Employee> multipleInsertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: EMPLOYEE")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("EmployeeResult")
    Optional<Employee> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: EMPLOYEE")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="EmployeeResult", value = {
        @Result(column="FIRST_NAME", property="firstName", jdbcType=JdbcType.VARCHAR),
        @Result(column="LAST_NAME", property="lastName", jdbcType=JdbcType.VARCHAR),
        @Result(column="EMAIL_ADDRESS", property="emailAddress", jdbcType=JdbcType.VARCHAR)
    })
    List<Employee> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: EMPLOYEE")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: EMPLOYEE")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, employee, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: EMPLOYEE")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, employee, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: EMPLOYEE")
    default int insert(Employee record) {
        return MyBatis3Utils.insert(this::insert, record, employee, c ->
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
    default int insertSelective(Employee record) {
        return MyBatis3Utils.insert(this::insert, record, employee, c ->
            c.map(firstName).toPropertyWhenPresent("firstName", record::getFirstName)
            .map(lastName).toPropertyWhenPresent("lastName", record::getLastName)
            .map(emailAddress).toPropertyWhenPresent("emailAddress", record::getEmailAddress)
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
    static UpdateDSL<UpdateModel> updateAllColumns(Employee record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(firstName).equalTo(record::getFirstName)
                .set(lastName).equalTo(record::getLastName)
                .set(emailAddress).equalTo(record::getEmailAddress);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: EMPLOYEE")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Employee record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(firstName).equalToWhenPresent(record::getFirstName)
                .set(lastName).equalToWhenPresent(record::getLastName)
                .set(emailAddress).equalToWhenPresent(record::getEmailAddress);
    }
}
