package com.alkemy.challenge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alkemy.challenge.entity.Pelicula;
import com.alkemy.challenge.repository.PeliculaRepo;

@Service
public class PeliculaService {

	@Autowired
	private PeliculaRepo peliculaRepo;
	
	public Pelicula savePelicula() {
		//Hacer las validaciones correspondientes
		Pelicula pelicula = new Pelicula();
		
		return peliculaRepo.save(pelicula);
	}
	
	public Pelicula updatePelicula() {
		return new Pelicula();
	}
	
	public Pelicula getPelicula() {
		return new Pelicula(); 
	}
	
	public void deletePelicula() {
		
	}
}
