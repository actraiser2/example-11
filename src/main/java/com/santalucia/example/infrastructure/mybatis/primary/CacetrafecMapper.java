package com.santalucia.example.infrastructure.mybatis.primary;

import static com.santalucia.example.infrastructure.mybatis.primary.CacetrafecDynamicSqlSupport.*;

import com.santalucia.example.infrastructure.entity.Cacetrafec;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import javax.annotation.Generated;
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

@Mapper
public interface CacetrafecMapper extends CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<Cacetrafec>, CommonUpdateMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: cacetrafec")
    BasicColumn[] selectList = BasicColumn.columnList(ccentrab, xcacetra, finvaldt, ffivaldt, fregilog);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: cacetrafec")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="CacetrafecResult", value = {
        @Result(column="ccentrab", property="ccentrab", jdbcType=JdbcType.SMALLINT),
        @Result(column="xcacetra", property="xcacetra", jdbcType=JdbcType.CHAR),
        @Result(column="finvaldt", property="finvaldt", jdbcType=JdbcType.DATE),
        @Result(column="ffivaldt", property="ffivaldt", jdbcType=JdbcType.DATE),
        @Result(column="fregilog", property="fregilog", jdbcType=JdbcType.TIMESTAMP)
    })
    List<Cacetrafec> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: cacetrafec")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("CacetrafecResult")
    Optional<Cacetrafec> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: cacetrafec")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, cacetrafec, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: cacetrafec")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, cacetrafec, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: cacetrafec")
    default int insert(Cacetrafec row) {
        return MyBatis3Utils.insert(this::insert, row, cacetrafec, c ->
            c.map(ccentrab).toProperty("ccentrab")
            .map(xcacetra).toProperty("xcacetra")
            .map(finvaldt).toProperty("finvaldt")
            .map(ffivaldt).toProperty("ffivaldt")
            .map(fregilog).toProperty("fregilog")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: cacetrafec")
    default int insertMultiple(Collection<Cacetrafec> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, cacetrafec, c ->
            c.map(ccentrab).toProperty("ccentrab")
            .map(xcacetra).toProperty("xcacetra")
            .map(finvaldt).toProperty("finvaldt")
            .map(ffivaldt).toProperty("ffivaldt")
            .map(fregilog).toProperty("fregilog")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: cacetrafec")
    default int insertSelective(Cacetrafec row) {
        return MyBatis3Utils.insert(this::insert, row, cacetrafec, c ->
            c.map(ccentrab).toPropertyWhenPresent("ccentrab", row::getCcentrab)
            .map(xcacetra).toPropertyWhenPresent("xcacetra", row::getXcacetra)
            .map(finvaldt).toPropertyWhenPresent("finvaldt", row::getFinvaldt)
            .map(ffivaldt).toPropertyWhenPresent("ffivaldt", row::getFfivaldt)
            .map(fregilog).toPropertyWhenPresent("fregilog", row::getFregilog)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: cacetrafec")
    default Optional<Cacetrafec> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, cacetrafec, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: cacetrafec")
    default List<Cacetrafec> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, cacetrafec, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: cacetrafec")
    default List<Cacetrafec> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, cacetrafec, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: cacetrafec")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, cacetrafec, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: cacetrafec")
    static UpdateDSL<UpdateModel> updateAllColumns(Cacetrafec row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(ccentrab).equalTo(row::getCcentrab)
                .set(xcacetra).equalTo(row::getXcacetra)
                .set(finvaldt).equalTo(row::getFinvaldt)
                .set(ffivaldt).equalTo(row::getFfivaldt)
                .set(fregilog).equalTo(row::getFregilog);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: cacetrafec")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Cacetrafec row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(ccentrab).equalToWhenPresent(row::getCcentrab)
                .set(xcacetra).equalToWhenPresent(row::getXcacetra)
                .set(finvaldt).equalToWhenPresent(row::getFinvaldt)
                .set(ffivaldt).equalToWhenPresent(row::getFfivaldt)
                .set(fregilog).equalToWhenPresent(row::getFregilog);
    }
}
