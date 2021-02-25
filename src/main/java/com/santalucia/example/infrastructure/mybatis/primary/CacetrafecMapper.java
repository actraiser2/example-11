package com.santalucia.example.infrastructure.mybatis.primary;

import static com.santalucia.example.infrastructure.mybatis.primary.CacetrafecDynamicSqlSupport.*;

import com.santalucia.example.infrastructure.entity.Cacetrafec;
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
public interface CacetrafecMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-25T09:38:09.5196319+01:00", comments="Source Table: cacetrafec")
    BasicColumn[] selectList = BasicColumn.columnList(ccentrab, xcacetra, finvaldt, ffivaldt, fregilog);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-25T09:38:09.5136303+01:00", comments="Source Table: cacetrafec")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-25T09:38:09.5146307+01:00", comments="Source Table: cacetrafec")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-25T09:38:09.5146307+01:00", comments="Source Table: cacetrafec")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<Cacetrafec> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-25T09:38:09.5146307+01:00", comments="Source Table: cacetrafec")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<Cacetrafec> multipleInsertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-25T09:38:09.5156309+01:00", comments="Source Table: cacetrafec")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("CacetrafecResult")
    Optional<Cacetrafec> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-25T09:38:09.5156309+01:00", comments="Source Table: cacetrafec")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="CacetrafecResult", value = {
        @Result(column="ccentrab", property="ccentrab", jdbcType=JdbcType.SMALLINT),
        @Result(column="xcacetra", property="xcacetra", jdbcType=JdbcType.CHAR),
        @Result(column="finvaldt", property="finvaldt", jdbcType=JdbcType.DATE),
        @Result(column="ffivaldt", property="ffivaldt", jdbcType=JdbcType.DATE),
        @Result(column="fregilog", property="fregilog", jdbcType=JdbcType.TIMESTAMP)
    })
    List<Cacetrafec> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-25T09:38:09.5166314+01:00", comments="Source Table: cacetrafec")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-25T09:38:09.5166314+01:00", comments="Source Table: cacetrafec")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, cacetrafec, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-25T09:38:09.5166314+01:00", comments="Source Table: cacetrafec")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, cacetrafec, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-25T09:38:09.5176309+01:00", comments="Source Table: cacetrafec")
    default int insert(Cacetrafec record) {
        return MyBatis3Utils.insert(this::insert, record, cacetrafec, c ->
            c.map(ccentrab).toProperty("ccentrab")
            .map(xcacetra).toProperty("xcacetra")
            .map(finvaldt).toProperty("finvaldt")
            .map(ffivaldt).toProperty("ffivaldt")
            .map(fregilog).toProperty("fregilog")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-25T09:38:09.5186315+01:00", comments="Source Table: cacetrafec")
    default int insertMultiple(Collection<Cacetrafec> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, cacetrafec, c ->
            c.map(ccentrab).toProperty("ccentrab")
            .map(xcacetra).toProperty("xcacetra")
            .map(finvaldt).toProperty("finvaldt")
            .map(ffivaldt).toProperty("ffivaldt")
            .map(fregilog).toProperty("fregilog")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-25T09:38:09.5186315+01:00", comments="Source Table: cacetrafec")
    default int insertSelective(Cacetrafec record) {
        return MyBatis3Utils.insert(this::insert, record, cacetrafec, c ->
            c.map(ccentrab).toPropertyWhenPresent("ccentrab", record::getCcentrab)
            .map(xcacetra).toPropertyWhenPresent("xcacetra", record::getXcacetra)
            .map(finvaldt).toPropertyWhenPresent("finvaldt", record::getFinvaldt)
            .map(ffivaldt).toPropertyWhenPresent("ffivaldt", record::getFfivaldt)
            .map(fregilog).toPropertyWhenPresent("fregilog", record::getFregilog)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-25T09:38:09.5206314+01:00", comments="Source Table: cacetrafec")
    default Optional<Cacetrafec> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, cacetrafec, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-25T09:38:09.5206314+01:00", comments="Source Table: cacetrafec")
    default List<Cacetrafec> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, cacetrafec, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-25T09:38:09.5216327+01:00", comments="Source Table: cacetrafec")
    default List<Cacetrafec> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, cacetrafec, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-25T09:38:09.5216327+01:00", comments="Source Table: cacetrafec")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, cacetrafec, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-25T09:38:09.5216327+01:00", comments="Source Table: cacetrafec")
    static UpdateDSL<UpdateModel> updateAllColumns(Cacetrafec record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(ccentrab).equalTo(record::getCcentrab)
                .set(xcacetra).equalTo(record::getXcacetra)
                .set(finvaldt).equalTo(record::getFinvaldt)
                .set(ffivaldt).equalTo(record::getFfivaldt)
                .set(fregilog).equalTo(record::getFregilog);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-25T09:38:09.5226324+01:00", comments="Source Table: cacetrafec")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Cacetrafec record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(ccentrab).equalToWhenPresent(record::getCcentrab)
                .set(xcacetra).equalToWhenPresent(record::getXcacetra)
                .set(finvaldt).equalToWhenPresent(record::getFinvaldt)
                .set(ffivaldt).equalToWhenPresent(record::getFfivaldt)
                .set(fregilog).equalToWhenPresent(record::getFregilog);
    }
}