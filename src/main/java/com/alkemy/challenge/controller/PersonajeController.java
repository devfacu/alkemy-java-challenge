package com.alkemy.challenge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alkemy.challenge.dto.PersonajeBasicDTO;
import com.alkemy.challenge.dto.PersonajeDTO;
import com.alkemy.challenge.service.PersonajeService;

@RestController
@RequestMapping("/characters")
public class PersonajeController {
	
	@Autowired
	private PersonajeService personajeService;
	
	@GetMapping("/")
	public ResponseEntity<List<PersonajeBasicDTO>> getAll() {
		List<PersonajeBasicDTO> personajes = personajeService.getAllPersonajesBasic();
		return ResponseEntity.ok().body(personajes);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PersonajeDTO> getDetailsById(@PathVariable String id) {
		PersonajeDTO dto = personajeService.getDetailsById(id);
		return ResponseEntity.ok(dto);
	}
	
	@GetMapping
	public ResponseEntity<List<PersonajeDTO>> getDetailsByFilter(
			@RequestParam(required = false) String name,
			@RequestParam(required = false) String age,
			@RequestParam(required = false) List<String> movies,
			@RequestParam(required = false, defaultValue = "ASC") String order
	){
		List<PersonajeDTO> personajes = personajeService.getByFilters(name, age, movies, order);
		return ResponseEntity.ok(personajes);
	}
	
	@PostMapping
	public ResponseEntity<PersonajeDTO> save(@RequestBody PersonajeDTO personaje) {
		PersonajeDTO personajeSaved = personajeService.save(personaje);
		return ResponseEntity.status(HttpStatus.CREATED).body(personajeSaved);
	}
	
	@PutMapping
	public ResponseEntity<PersonajeDTO> update(@RequestBody PersonajeDTO personaje) {
		PersonajeDTO personajeUpdated = personajeService.updatePersonaje(personaje);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(personajeUpdated);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		personajeService.deletePersonaje(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
