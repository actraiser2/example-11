package com.santalucia.example.core.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Table(name = "accuinsflu") 
public class AccuinsfluDomain {

	@Id
	private String nidinflu;
	private String cflutrab;
	private Integer cactiflu;
	private Double pgradava;
}
