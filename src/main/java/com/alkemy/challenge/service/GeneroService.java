package com.alkemy.challenge.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.alkemy.challenge.entity.Genero;
import com.alkemy.challenge.error.ServiceError;
import com.alkemy.challenge.repository.GeneroRepo;

public class GeneroService {
	//CRUD
	
	@Autowired
	private GeneroRepo generoRepo;
	
	@Transactional
	public Genero saveGenero() {
		Genero genero = new Genero();
		return generoRepo.save(genero);
	}
	
	@Transactional
	public Genero updateGenero(String genero_id) throws ServiceError {
		Optional<Genero> ans = generoRepo.findById(genero_id);
		Genero genero;
		if (ans.isPresent()) {
			 genero = ans.get();
		} else {
			throw new ServiceError("El genero solicitado no existe.");
		}
		return generoRepo.save(genero);
	}
}
