package com.santalucia.example.api.server;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.Random;
import java.util.Set;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter.DataWithMediaType;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import com.santalucia.arq.ams.componentes.core.properties.reload.AmsCoreProperties;

/**
 * Controler para ServerSentEvents
 *
 */
@RestController
@EnableConfigurationProperties(AmsCoreProperties.class)
public class ProgressController {

	private final Random rand;
	private final AmsCoreProperties properties;

	/**
	 * ProgressController
	 * @param AmsCoreProperties properties
	 * @throws NoSuchAlgorithmException
	 */
    public ProgressController(AmsCoreProperties properties) throws NoSuchAlgorithmException {
    	this.rand = SecureRandom.getInstanceStrong();  // SecureRandom is preferred to Random
    	this.properties = properties;
    }

	/**
	 * @return ResponseEntity<SseEmitter>
	 * @throws IOException
	 */
	@GetMapping("/getData")
	public ResponseEntity<SseEmitter> getData() throws IOException {
		SseEmitter sseEmitter = new SseEmitter(Long.MAX_VALUE);

		Set<DataWithMediaType> event = SseEmitter.event()
			.name("timestamp")
			.data(LocalDate.now(properties.defaultZoneId()) + " Nº del 1-100: " + rand.nextInt(100))
			.build();

		sseEmitter.send(event);
		return new ResponseEntity<>(sseEmitter, HttpStatus.OK);
	}

}
