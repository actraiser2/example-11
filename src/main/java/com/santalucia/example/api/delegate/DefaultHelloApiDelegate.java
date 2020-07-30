package com.santalucia.example.api.delegate;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.santalucia.example.api.web.HelloApiDelegate;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class DefaultHelloApiDelegate implements HelloApiDelegate {
	
	private final ObjectMapper objectMapper;
	private final HttpServletRequest request;
	
	@Autowired
	public DefaultHelloApiDelegate(ObjectMapper objectMapper, HttpServletRequest request) {
	    this.objectMapper = objectMapper;
	    this.request = request;
	    log.debug("DefaultHelloApiDelegate loaded");
	}
	
	
	@Override
	public Optional<ObjectMapper> getObjectMapper() {
	    return Optional.ofNullable(objectMapper);
	}

	@Override
	public Optional<HttpServletRequest> getRequest() {
	    return Optional.ofNullable(request);
	}

	
}