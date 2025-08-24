package com.santalucia.example.api.delegate;

import java.util.concurrent.CompletableFuture;

import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.santalucia.arq.ams.api.client.GestorDocumentalApi;
import com.santalucia.example.api.model.DocumentoResource;
import com.santalucia.example.api.server.GestorDocumentalApiDelegate;
import com.santalucia.example.core.mappers.DocumentResourceMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 */
@RequiredArgsConstructor
@Component
@Slf4j
public class DefaultGestorDocumentalApiDelegate implements GestorDocumentalApiDelegate {

	private final GestorDocumentalApi gestorDocumentalApi;
	private final DocumentResourceMapper documentResourceMapper;
	private final DiscoveryClient discoveryClient;
	
	
	/**
	 *  recuperarDocumento
	 */
	@Override
	public CompletableFuture<ResponseEntity<DocumentoResource>> recuperarDocumento(Long id) {
		
		
		log.info("Discovery Client for service repositorui-documental {}", 
				discoveryClient.getInstances("repositorio-documental"));
		
		var response = gestorDocumentalApi.recuperarDocumento(id).getBody();
		var documentResource = documentResourceMapper.toDocumentoResource(response);
		
		
		
		return CompletableFuture.completedFuture(ResponseEntity.ok(documentResource));
	}

}
