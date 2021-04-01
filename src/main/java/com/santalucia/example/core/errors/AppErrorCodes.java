package com.santalucia.example.core.errors;



import com.santalucia.arq.ams.componentes.exceptions.ErrorCode;

import lombok.Getter;

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

