package com.alkemy.challenge.service;

import com.alkemy.challenge.dto.PersonajeDTO;
import com.alkemy.challenge.entity.Personaje;

public interface PersonajeService {

	PersonajeDTO save(PersonajeDTO dto);
	
	Personaje updatePersonaje(String personaje_id);
	
	void deletePersonaje();
}
