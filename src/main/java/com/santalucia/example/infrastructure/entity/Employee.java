package com.santalucia.example.infrastructure.entity;

import jakarta.annotation.Generated;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Employee {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: EMPLOYEE.FIRST_NAME")
    private String firstName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: EMPLOYEE.LAST_NAME")
    private String lastName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: EMPLOYEE.EMAIL_ADDRESS")
    private String emailAddress;
}
