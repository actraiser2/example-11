package com.santalucia.example.core.domain;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;


/**
 * IndicadoresCentroDomain
 *
 */
@Data
@Builder
public class IndicadoresCentroDomain {

	private Short ccentrab;
	private String xcacetra;
	private LocalDate finvaldt;
	private LocalDate ffivaldt;
	private LocalDate fregilog;
}
