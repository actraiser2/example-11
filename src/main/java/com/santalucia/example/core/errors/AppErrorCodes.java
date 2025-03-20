package com.santalucia.example.core.errors;

import lombok.Getter;

import com.santalucia.arq.ams.componentes.exceptions.errors.ErrorCode;

@Getter
public enum AppErrorCodes implements ErrorCode {

	INVALID_NAME("app.error.invalid.name");


	private final String code;

	private AppErrorCodes(String code) {
		this.code = code;
	}

	@Override
	public String getCode() {
		return this.code;
	}
}
