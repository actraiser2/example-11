package com.santalucia.example.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Random;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ProgressController {

	@GetMapping("/getData")
	public SseEmitter getData() throws IOException {
		SseEmitter sseEmitter = new SseEmitter(Long.MAX_VALUE);
		sseEmitter.send(SseEmitter.event().name("timestamp")
				.data(LocalDate.now() + " Nº del 1-100: " + (new Random().nextInt(100) ) ) );
		return sseEmitter;
	}

}
