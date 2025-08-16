package com.santalucia.example.infrastructure.mixins;

import org.springframework.boot.jackson.JsonComponent;
import org.springframework.boot.jackson.JsonMixin;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.santalucia.example.api.model.IndicadorResource;

@JsonMixin(IndicadorResource.class)
@JsonComponent
public interface IndicadorResourceMixin {
	@JsonProperty("ccentrabMixin") Integer ccentrab();
}
