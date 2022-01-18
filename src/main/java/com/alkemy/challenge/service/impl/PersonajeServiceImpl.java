package com.alkemy.challenge.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alkemy.challenge.dto.PersonajeDTO;
import com.alkemy.challenge.entity.Personaje;
import com.alkemy.challenge.mapper.PersonajeMapper;
import com.alkemy.challenge.repository.PersonajeRepo;
import com.alkemy.challenge.service.PersonajeService;

@Service
public class PersonajeServiceImpl implements PersonajeService{
	
	@Autowired
	private PersonajeMapper personajeMapper;
	
	@Autowired
	private PersonajeRepo personajeRepo;
	
	public PersonajeDTO save(PersonajeDTO dto) {
		Personaje personaje = personajeMapper.personajeDTO2Entity(dto);
		Personaje personajeSaved = personajeRepo.save(personaje);
		PersonajeDTO result = personajeMapper.personajeEntity2DTO(personajeSaved);
		return result;
	}
	
	public Personaje updatePersonaje(String personaje_id){
		Personaje personaje;
		Optional<Personaje> ans = personajeRepo.findById(personaje_id);
		if (ans.isPresent()) {
			personaje = ans.get();
			return personajeRepo.save(personaje);
		} else {
			return personaje = new Personaje();
		}
	}
	
	public Personaje getPersonajeBy(String personaje_id) {
		return personajeRepo.getById(personaje_id);
	}
	
	public List<Personaje> getPersonajes(){
		return personajeRepo.findAll();
	}
	
	public void deletePersonaje() {
		Personaje personaje = new Personaje();
		personajeRepo.delete(personaje);
	}
}
