package com.santalucia.example.core.service;

import java.util.Optional;

import com.santalucia.example.core.domain.IdentidadDigitalDomain;

public interface HelloService {

    /**
     * getHello
     * @param String name
     * @return IdentidadDigitalDomain
     */
	Optional<IdentidadDigitalDomain> getHelloRemoteByName(String name);

	/**
	 * getHelloByName
	 * @param name
	 * @return String
	 */
	IdentidadDigitalDomain getHelloByName(String name);

}
