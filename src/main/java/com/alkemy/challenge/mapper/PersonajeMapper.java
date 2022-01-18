package com.alkemy.challenge.mapper;

import com.alkemy.challenge.dto.PersonajeDTO;
import com.alkemy.challenge.entity.Personaje;

public class PersonajeMapper {
	
	public Personaje personajeDTO2Entity(PersonajeDTO dto) {
		Personaje personaje = new Personaje();
		personaje.setImagen(dto.getImagen());
		personaje.setNombre(dto.getNombre());
		personaje.setEdad(dto.getEdad());
		personaje.setPeso(dto.getPeso());
		personaje.setHistoria(dto.getHistoria());
		
		return personaje;
	}
	
	public PersonajeDTO personajeEntity2DTO(Personaje entity) {
		PersonajeDTO dto = new PersonajeDTO();
		dto.setId(entity.getId());
		dto.setImagen(entity.getImagen());
		dto.setNombre(entity.getNombre());
		dto.setEdad(entity.getEdad());
		dto.setPeso(entity.getPeso());
		dto.setHistoria(entity.getHistoria());
		
		return dto;
	}
}
