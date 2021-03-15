/*
 * Copyright 2002-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.santalucia.example.api.delegate;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.santalucia.example.api.model.IdentidadDigitalConsultaResource;
import com.santalucia.example.api.server.HelloApiDelegate;
import com.santalucia.example.core.mappers.IdentidadDigitalDomainMapper;
import com.santalucia.example.core.service.HelloService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class DefaultHelloApiDelegate implements HelloApiDelegate {

	private final HelloService helloService;
	private final IdentidadDigitalDomainMapper identidadDigitalDomainMapper;

	@Autowired
	public DefaultHelloApiDelegate(HelloService helloService, IdentidadDigitalDomainMapper identidadDigitalDomainMapper) {

		this.helloService = helloService;
		this.identidadDigitalDomainMapper = identidadDigitalDomainMapper;
		log.debug("DefaultHelloApiDelegate loaded");
	}

	@Override
	public ResponseEntity<IdentidadDigitalConsultaResource> getHelloByName(String name, Optional<UUID> xRequestId) {

		return Optional
				.ofNullable(helloService.getHello(name))
				.map(idDomain -> ResponseEntity.ok().body(identidadDigitalDomainMapper.toResource(idDomain))) // 200 OK
				.orElse(ResponseEntity.notFound().build()); // 404 Not found
	}

}
