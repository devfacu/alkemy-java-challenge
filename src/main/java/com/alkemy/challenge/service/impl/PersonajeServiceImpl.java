package com.alkemy.challenge.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alkemy.challenge.dto.PersonajeBasicDTO;
import com.alkemy.challenge.dto.PersonajeDTO;
import com.alkemy.challenge.dto.PersonajeFiltersDTO;
import com.alkemy.challenge.entity.Pelicula;
import com.alkemy.challenge.entity.Personaje;
import com.alkemy.challenge.mapper.PeliculaMapper;
import com.alkemy.challenge.mapper.PersonajeMapper;
import com.alkemy.challenge.repository.PersonajeRepository;
import com.alkemy.challenge.repository.specifications.PersonajeSpecification;
import com.alkemy.challenge.service.PersonajeService;

@Service
public class PersonajeServiceImpl implements PersonajeService{
	
	@Autowired
	private PersonajeMapper personajeMapper;
	
	@Autowired
	private PeliculaMapper peliculaMapper;
	
	@Autowired
	private PersonajeRepository personajeRepo;
	
	@Autowired
	private PersonajeSpecification personajeSpec;
	
	public PersonajeDTO save(PersonajeDTO dto) {
		Personaje personaje = personajeMapper.toEntity(dto);
		//Try-catch implemented to avoid NullPointerException
		try {
			if (!dto.getPeliculas().isEmpty()) {
				List<Pelicula> peliculas = this.peliculaMapper.toEntityList(dto.getPeliculas());
				personaje.setPeliculas(peliculas);
			}
		} catch (NullPointerException e) {
			//Do nothing
		}
		Personaje personajeSaved = personajeRepo.save(personaje);
		PersonajeDTO result = personajeMapper.toDTO(personajeSaved, false);
		return result;
	}
	
	public PersonajeDTO updatePersonaje(PersonajeDTO dto){
		Optional<Personaje> ans = personajeRepo.findById(dto.getId());
		Personaje personaje;
		if (ans.isPresent()) {
			personaje = ans.get();
		} else {
			//throw error
			personaje = null;
		}
		
		try {
			if (!dto.getPeliculas().isEmpty()) {
				List<Pelicula> peliculas = this.peliculaMapper.toEntityList(dto.getPeliculas());
				personaje.setPeliculas(peliculas);
			}
		} catch (NullPointerException e) {
			//Do nothing
		}
		personajeRepo.save(personaje);
		return dto;
	}

	public PersonajeDTO getDetailsById(String id) {
		Personaje personaje = personajeRepo.getById(id);
		PersonajeDTO dto = personajeMapper.toDTO(personaje, true);
		return dto;
	}

	public List<PersonajeDTO> getByFilters(String name, String age, List<String> movies, String order) {
		PersonajeFiltersDTO filtersDTO = new PersonajeFiltersDTO(name, age, movies, order);
		List<Personaje> entities = personajeRepo.findAll(personajeSpec.getByFilters(filtersDTO));
		List<PersonajeDTO> dtos = personajeMapper.toDTOList(entities, true);
		return dtos;
	}
	
	public List<PersonajeBasicDTO> getAllPersonajesBasic(){
		List<Personaje> entities = personajeRepo.findAll();
		List<PersonajeBasicDTO> dtos = personajeMapper.toBasicDTOList(entities);
		return dtos;
	}
	
	public void deletePersonaje(String id) {
		personajeRepo.deleteById(id);
	}
	
}
