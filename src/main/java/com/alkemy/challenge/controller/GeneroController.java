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
import org.springframework.web.bind.annotation.RestController;

import com.alkemy.challenge.dto.GeneroDTO;
import com.alkemy.challenge.service.GeneroService;

@RestController
@RequestMapping("/genres")
public class GeneroController {
	
	@Autowired
	private GeneroService generoService;
	
	@GetMapping
	public ResponseEntity<List<GeneroDTO>> getAll() {
		List<GeneroDTO> generos = generoService.getAll();
		return ResponseEntity.ok().body(generos);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<GeneroDTO> getById(@PathVariable String id) {
		GeneroDTO dto = generoService.getById(id);
		return ResponseEntity.ok(dto);
	}
	
	@PostMapping
	public ResponseEntity<GeneroDTO> save(@RequestBody GeneroDTO genero) {
		GeneroDTO generoSaved = generoService.save(genero);
		return ResponseEntity.status(HttpStatus.CREATED).body(generoSaved);
	}
	
	@PutMapping
	public ResponseEntity<GeneroDTO> update(@RequestBody GeneroDTO genero) {
		GeneroDTO generoUpdated = generoService.update(genero);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(generoUpdated);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		generoService.delete(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
