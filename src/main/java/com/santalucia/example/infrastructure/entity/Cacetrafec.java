package com.santalucia.example.infrastructure.entity;

import java.util.Date;
import javax.annotation.Generated;

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
    public Date getFinvaldt() {
        return finvaldt;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: cacetrafec.finvaldt")
    public void setFinvaldt(Date finvaldt) {
        this.finvaldt = finvaldt;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: cacetrafec.ffivaldt")
    public Date getFfivaldt() {
        return ffivaldt;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: cacetrafec.ffivaldt")
    public void setFfivaldt(Date ffivaldt) {
        this.ffivaldt = ffivaldt;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: cacetrafec.fregilog")
    public Date getFregilog() {
        return fregilog;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: cacetrafec.fregilog")
    public void setFregilog(Date fregilog) {
        this.fregilog = fregilog;
    }
}
