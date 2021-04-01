package com.santalucia.example.core.exceptions;

import com.santalucia.arq.ams.componentes.exceptions.SantaluciaBusinessException;
import com.santalucia.example.core.errors.AppErrorCodes;

public class InvalidNameException extends SantaluciaBusinessException {

	private static final long serialVersionUID = -4839425922066569485L;

	public InvalidNameException(Throwable cause) {
		super(AppErrorCodes.INVALID_NAME,cause);
	}
}