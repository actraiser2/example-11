package com.santalucia.example.core.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AgenciaDomain {

	private String dprov;

	private String dpoblaci;

	private String dagencia;

	private String dtvia;

	private String ddomici;

}
