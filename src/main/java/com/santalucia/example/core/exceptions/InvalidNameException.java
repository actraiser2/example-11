package com.santalucia.example.core.exceptions;

import com.santalucia.arq.ams.componentes.errors.HttpErrorCodes;
import com.santalucia.arq.ams.componentes.exceptions.core.SantaluciaWebRuntimeException;
import com.santalucia.example.core.errors.AppErrorCodes;

public class InvalidNameException extends SantaluciaWebRuntimeException {

	private static final long serialVersionUID = -4839425922066569485L;

	public InvalidNameException(Throwable cause) {
		super(AppErrorCodes.INVALID_NAME,HttpErrorCodes.HTTP_440,cause);
	}
}