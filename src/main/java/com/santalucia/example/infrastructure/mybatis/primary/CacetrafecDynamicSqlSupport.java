package com.santalucia.example.infrastructure.mybatis.primary;

import java.sql.JDBCType;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class CacetrafecDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: cacetrafec")
    public static final Cacetrafec cacetrafec = new Cacetrafec();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: cacetrafec.ccentrab")
    public static final SqlColumn<Short> ccentrab = cacetrafec.ccentrab;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: cacetrafec.xcacetra")
    public static final SqlColumn<String> xcacetra = cacetrafec.xcacetra;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: cacetrafec.finvaldt")
    public static final SqlColumn<LocalDate> finvaldt = cacetrafec.finvaldt;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: cacetrafec.ffivaldt")
    public static final SqlColumn<LocalDate> ffivaldt = cacetrafec.ffivaldt;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: cacetrafec.fregilog")
    public static final SqlColumn<LocalDateTime> fregilog = cacetrafec.fregilog;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: cacetrafec")
    public static final class Cacetrafec extends SqlTable {
        public final SqlColumn<Short> ccentrab = column("ccentrab", JDBCType.SMALLINT);

        public final SqlColumn<String> xcacetra = column("xcacetra", JDBCType.CHAR);

        public final SqlColumn<LocalDate> finvaldt = column("finvaldt", JDBCType.DATE);

        public final SqlColumn<LocalDate> ffivaldt = column("ffivaldt", JDBCType.DATE);

        public final SqlColumn<LocalDateTime> fregilog = column("fregilog", JDBCType.TIMESTAMP);

        public Cacetrafec() {
            super("cacetrafec");
        }
    }
}