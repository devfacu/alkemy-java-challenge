package com.alkemy.challenge.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.alkemy.challenge.dto.PeliculaDTO;
import com.alkemy.challenge.dto.PersonajeBasicDTO;
import com.alkemy.challenge.dto.PersonajeDTO;
import com.alkemy.challenge.entity.Personaje;


@Component
public class PersonajeMapper {
	
	@Autowired
	private PeliculaMapper peliculaMapper;
	
	public Personaje toEntity(PersonajeDTO dto) {
		Personaje entity = new Personaje();
		
		String dtoId = dto.getId();
		if (StringUtils.hasLength(dtoId)) {
			entity.setId(dtoId);
		}
		
		entity.setImagen(dto.getImagen());
		entity.setNombre(dto.getNombre());
		entity.setEdad(dto.getEdad());
		entity.setPeso(dto.getPeso());
		entity.setHistoria(dto.getHistoria());
		
		return entity;
	}
	
	public PersonajeDTO toDTO(Personaje entity, boolean loadPeliculas) {
		PersonajeDTO dto = new PersonajeDTO();
		dto.setId(entity.getId());
		dto.setImagen(entity.getImagen());
		dto.setNombre(entity.getNombre());
		dto.setEdad(entity.getEdad());
		dto.setPeso(entity.getPeso());
		dto.setHistoria(entity.getHistoria());
		if (loadPeliculas) {
			List<PeliculaDTO> peliculasDTO = this.peliculaMapper.toDTOList(entity.getPeliculas(), false);
			dto.setPeliculas(peliculasDTO);
		}
		return dto;
	}
	
	public List<PersonajeDTO> toDTOList(List<Personaje> entities, boolean loadPeliculas) {
		List<PersonajeDTO> dtos = new ArrayList<>();
		for (Personaje entity : entities) {
			dtos.add(this.toDTO(entity, loadPeliculas));
		}
		return dtos;
	}
	
	public List<PersonajeBasicDTO> toBasicDTOList(List<Personaje> entities) {
		List<PersonajeBasicDTO> dtos = new ArrayList<>();
		PersonajeBasicDTO basicDTO;
		
		for (Personaje entity : entities) {
			basicDTO = new PersonajeBasicDTO();
			basicDTO.setId(entity.getId());
			basicDTO.setImagen(entity.getImagen());
			basicDTO.setNombre(entity.getNombre());
			dtos.add(basicDTO);
		}
		return dtos;
	}
	
	public void entityRefreshValues(Personaje personaje, PersonajeDTO dto) {
		personaje.setImagen(dto.getImagen());
		personaje.setNombre(dto.getNombre());
		personaje.setEdad(dto.getEdad());
		personaje.setPeso(dto.getPeso());
		personaje.setHistoria(dto.getHistoria());
		
	}
	
	public List<Personaje> toEntityList(List<PersonajeDTO> dtos){
		List<Personaje> entities = new ArrayList<>();
		for (PersonajeDTO dto : dtos) {
			entities.add(this.toEntity(dto));
		}
		return entities;
	}
}
