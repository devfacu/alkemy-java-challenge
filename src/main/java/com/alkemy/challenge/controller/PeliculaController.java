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

import com.alkemy.challenge.dto.PeliculaBasicDTO;
import com.alkemy.challenge.dto.PeliculaDTO;
import com.alkemy.challenge.service.PeliculaService;

@RestController
@RequestMapping("/movies")
public class PeliculaController {
	
	@Autowired
	private PeliculaService peliculaService;
	
	@GetMapping("/")
	public ResponseEntity<List<PeliculaBasicDTO>> getAll() {
		List<PeliculaBasicDTO> peliculas = peliculaService.getAllPeliculasBasic();
		return ResponseEntity.ok(peliculas);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PeliculaDTO> getDetailsById(@PathVariable String id) {
		PeliculaDTO dto = peliculaService.getDetailsById(id);
		return ResponseEntity.ok(dto);
	}
	
	@GetMapping
	public ResponseEntity<List<PeliculaDTO>> getDetailsByFilter(
			@RequestParam(required = false) String name,
			@RequestParam(required = false) String genre,
			@RequestParam(required = false, defaultValue = "ASC") String order
	){
		List<PeliculaDTO> peliculas = peliculaService.getByFilters(name, genre, order);
		return ResponseEntity.ok(peliculas);
	}
	
	@PostMapping
	public ResponseEntity<PeliculaDTO> save(@RequestBody PeliculaDTO pelicula) {
		PeliculaDTO peliculaSaved = peliculaService.save(pelicula);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(peliculaSaved);
	}
	
	@PutMapping
	public ResponseEntity<PeliculaDTO> update(@RequestBody PeliculaDTO pelicula) {
		PeliculaDTO peliculaUpdated = peliculaService.update(pelicula);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(peliculaUpdated);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		peliculaService.deletePelicula(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
