package com.santalucia.example.infrastructure.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.annotation.Generated;

public class Cacetrafec {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: cacetrafec.ccentrab")
    private Short ccentrab;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: cacetrafec.xcacetra")
    private String xcacetra;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: cacetrafec.finvaldt")
    private LocalDate finvaldt;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: cacetrafec.ffivaldt")
    private LocalDate ffivaldt;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: cacetrafec.fregilog")
    private LocalDateTime fregilog;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: cacetrafec.ccentrab")
    public Short getCcentrab() {
        return ccentrab;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: cacetrafec.ccentrab")
    public void setCcentrab(Short ccentrab) {
        this.ccentrab = ccentrab;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: cacetrafec.xcacetra")
    public String getXcacetra() {
        return xcacetra;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: cacetrafec.xcacetra")
    public void setXcacetra(String xcacetra) {
        this.xcacetra = xcacetra == null ? null : xcacetra.trim();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: cacetrafec.finvaldt")
    public LocalDate getFinvaldt() {
        return finvaldt;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: cacetrafec.finvaldt")
    public void setFinvaldt(LocalDate finvaldt) {
        this.finvaldt = finvaldt;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: cacetrafec.ffivaldt")
    public LocalDate getFfivaldt() {
        return ffivaldt;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: cacetrafec.ffivaldt")
    public void setFfivaldt(LocalDate ffivaldt) {
        this.ffivaldt = ffivaldt;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: cacetrafec.fregilog")
    public LocalDateTime getFregilog() {
        return fregilog;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: cacetrafec.fregilog")
    public void setFregilog(LocalDateTime fregilog) {
        this.fregilog = fregilog;
    }
}