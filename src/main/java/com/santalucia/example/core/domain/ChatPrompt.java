package com.santalucia.example.core.domain;

import org.springframework.boot.context.properties.bind.DefaultValue;

import jakarta.validation.constraints.NotNull;

public record ChatPrompt( @NotNull String query, @DefaultValue("0") double temperature) {

}
