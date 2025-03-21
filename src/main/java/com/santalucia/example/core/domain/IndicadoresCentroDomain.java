package com.santalucia.example.core.domain;

import java.time.LocalDate;


import lombok.Builder;
import lombok.Data;


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
