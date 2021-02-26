package com.santalucia.example.infrastructure.entity;

import javax.annotation.Generated;

public class Employee {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: EMPLOYEE.FIRST_NAME")
    private String firstName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: EMPLOYEE.LAST_NAME")
    private String lastName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: EMPLOYEE.EMAIL_ADDRESS")
    private String emailAddress;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: EMPLOYEE.FIRST_NAME")
    public String getFirstName() {
        return firstName;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: EMPLOYEE.FIRST_NAME")
    public void setFirstName(String firstName) {
        this.firstName = firstName == null ? null : firstName.trim();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: EMPLOYEE.LAST_NAME")
    public String getLastName() {
        return lastName;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: EMPLOYEE.LAST_NAME")
    public void setLastName(String lastName) {
        this.lastName = lastName == null ? null : lastName.trim();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: EMPLOYEE.EMAIL_ADDRESS")
    public String getEmailAddress() {
        return emailAddress;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: EMPLOYEE.EMAIL_ADDRESS")
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress == null ? null : emailAddress.trim();
    }
}