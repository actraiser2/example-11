package com.santalucia.example.core.domain;

import java.util.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class IndicadoresCentroDomain {

	private Short ccentrab;

	private String xcacetra;

	private Date finvaldt;

	private Date ffivaldt;

	private Date fregilog;

}
