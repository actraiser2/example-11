package com.santalucia.example.infrastructure.entity;

import java.util.Date;
import jakarta.annotation.Generated;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Cacetrafec {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: cacetrafec.ccentrab")
    private Short ccentrab;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: cacetrafec.xcacetra")
    private String xcacetra;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: cacetrafec.finvaldt")
    private Date finvaldt;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: cacetrafec.ffivaldt")
    private Date ffivaldt;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: cacetrafec.fregilog")
    private Date fregilog;
}
