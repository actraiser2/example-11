package com.santalucia.example.core.service;

import com.santalucia.example.core.domain.IdentidadDigitalDomain;

public interface HelloService {

    /**
     * getHello
     * @param String name
     * @return IdentidadDigitalDomain
     */
	public IdentidadDigitalDomain getHelloRemoteByName(String name);
	
	/**
	 * getHelloByName
	 * @param name
	 * @return String
	 */
	public IdentidadDigitalDomain getHelloByName(String name);

}
