package com.santalucia.example.infrastructure.entity;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Table("CACETRAFEC")
public class Cacetrafec {

    @Id
    @Column("CCENTRAB")
    private Integer ccentrab;

    @Column("XCACETRA")
    private String xcacetra;

    @Column("FINVALDT")
    private LocalDate finvaldt;

    @Column("FFIVALDT")
    private LocalDate ffivaldt;

    @Column("FREGILOG")
    private LocalDate fregilog;

}
