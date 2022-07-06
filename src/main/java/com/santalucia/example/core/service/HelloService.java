package com.santalucia.example.core.service;

import java.util.Optional;

import com.santalucia.example.core.domain.IdentidadDigitalDomain;
import java.util.concurrent.ExecutionException;

public interface HelloService {

    /**
     * getHello
     * @param String name
     * @return IdentidadDigitalDomain
     */
	public Optional<IdentidadDigitalDomain> getHelloRemoteByName(String name) throws ExecutionException, InterruptedException;

	/**
	 * getHelloByName
	 * @param name
	 * @return String
	 */
	public IdentidadDigitalDomain getHelloByName(String name);

}
