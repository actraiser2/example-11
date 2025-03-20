package com.santalucia.example.core.exceptions;

import java.io.Serial;


import org.springframework.lang.Nullable;

import com.santalucia.arq.ams.componentes.web.exceptions.core.SantaluciaWebRuntimeException;
import com.santalucia.example.core.errors.AppErrorCodes;


/**
 * InvalidNameException
 *
 */
public class InvalidNameException extends SantaluciaWebRuntimeException {

    @Serial
    private static final long serialVersionUID = -4839425922066569485L;

    /**
     * constructor de clase
     *
     * @param Throwable cause
     */
	public InvalidNameException(@Nullable Throwable cause) {
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
