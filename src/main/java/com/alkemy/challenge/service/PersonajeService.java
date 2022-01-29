package com.alkemy.challenge.service;

import java.util.List;

import com.alkemy.challenge.dto.PersonajeBasicDTO;
import com.alkemy.challenge.dto.PersonajeDTO;

public interface PersonajeService {

	PersonajeDTO save(PersonajeDTO dto);
	
	List<PersonajeBasicDTO> getAllPersonajesBasic();
	
	PersonajeDTO updatePersonaje(PersonajeDTO dto);
	
	void deletePersonaje(String id);

	PersonajeDTO getDetailsById(String id);

	List<PersonajeDTO> getByFilters(String name, String age, List<String> movies, String order);
}
