package com.santalucia.example.core.exceptions;

import com.santalucia.arq.ams.componentes.web.exceptions.core.SantaluciaWebRuntimeException;
import com.santalucia.example.core.errors.AppErrorCodes;

public class InvalidNameException extends SantaluciaWebRuntimeException {

	private static final long serialVersionUID = -4839425922066569485L;

    /**
     * constructor de clase
     *
     * @param Throwable cause
     */
	public InvalidNameException(Throwable cause) {
		super(AppErrorCodes.INVALID_NAME,cause);
	}

    /**
     * constructor de clase
     *
     */
	public InvalidNameException() {
		this(null);
	}
}
