package com.santalucia.example.infrastructure.entity;

import java.util.Date;


import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

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
    private Date finvaldt;

    @Column("FFIVALDT")
    private Date ffivaldt;

    @Column("FREGILOG")
    private Date fregilog;

}
