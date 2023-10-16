package com.lex.practice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * @author : Lex Yu
 */
@RestController
public class TryController {

	private WebClient webClient;

	@PostMapping
	public ResponseEntity<?> getGenericData() {



		return ResponseEntity.ok().build();
	}


}
