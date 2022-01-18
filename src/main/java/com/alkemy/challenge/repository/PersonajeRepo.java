package com.alkemy.challenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alkemy.challenge.entity.Personaje;

@Repository
public interface PersonajeRepo extends JpaRepository<Personaje, String>{

	
}
