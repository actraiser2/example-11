package com.santalucia.example.infrastructure.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Builder
@Table("EMPLOYEE")
public class Employee {

    @Id
    @Column("ID")
    private Long id;

    @Column("FIRST_NAME")
    private String firstName;

    @Column("LAST_NAME")
    private String lastName;

    @Column("EMAIL_ADDRESS")
    private String emailAddress;

}
