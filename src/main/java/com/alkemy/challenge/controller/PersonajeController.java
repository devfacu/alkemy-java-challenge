package com.alkemy.challenge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alkemy.challenge.dto.PersonajeDTO;
import com.alkemy.challenge.service.PersonajeService;

@RestController
@RequestMapping("/characters")
public class PersonajeController {
	
	@Autowired
	private PersonajeService personajeService;
	
	@PostMapping
	public ResponseEntity<PersonajeDTO> save(@RequestBody PersonajeDTO personaje) {
		// save personaje
		PersonajeDTO personajeSaved = personajeService.save(personaje);
		return ResponseEntity.status(HttpStatus.CREATED).body(personajeSaved);
	}
}
