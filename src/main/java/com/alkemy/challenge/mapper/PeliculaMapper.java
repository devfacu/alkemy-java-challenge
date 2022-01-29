package com.alkemy.challenge.mapper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.alkemy.challenge.dto.PeliculaBasicDTO;
import com.alkemy.challenge.dto.PeliculaDTO;
import com.alkemy.challenge.dto.PersonajeDTO;
import com.alkemy.challenge.entity.Pelicula;

@Component
public class PeliculaMapper {
	
	@Autowired
	private PersonajeMapper personajeMapper;
	
	public Pelicula toEntity(PeliculaDTO dto) {
		Pelicula entity = new Pelicula();
		String dtoId = dto.getId();
		if (StringUtils.hasLength(dtoId)) {
			entity.setId(dtoId);
		}
		entity.setImagen(dto.getImagen());
		entity.setTitulo(dto.getTitulo());
		entity.setFechaCreacion(
				this.string2LocalDate(dto.getFechaCreacion())
		);
		entity.setCalificacion(dto.getCalificacion());
		entity.setGeneroId(dto.getGenero());
		
		return entity;
	}
	
	public PeliculaDTO toDTO(Pelicula entity, boolean loadPersonajes) {
		PeliculaDTO dto = new PeliculaDTO();
		dto.setId(entity.getId());
		dto.setImagen(entity.getImagen());
		dto.setTitulo(entity.getTitulo());
		dto.setFechaCreacion(entity.getFechaCreacion().toString());
		dto.setCalificacion(entity.getCalificacion());
		dto.setGenero(entity.getGeneroId());
		
		if (loadPersonajes) {
			List<PersonajeDTO> personajes = this.personajeMapper.toDTOList(entity.getPersonajes(), false);
			dto.setPersonajes(personajes);
		}
		
		return dto;
	}
	
	public List<PeliculaDTO> toDTOList(List<Pelicula> entities, boolean loadPersonajes){
		List<PeliculaDTO> dtos = new ArrayList<>();
		for (Pelicula entity : entities) {
			dtos.add(this.toDTO(entity, loadPersonajes));
		}
		return dtos;
	}
	
	public List<PeliculaBasicDTO> toBasicDTOList(List<Pelicula> entities) {
		List<PeliculaBasicDTO> dtos = new ArrayList<>();
		PeliculaBasicDTO basicDTO;
		
		for (Pelicula entity : entities) {
			basicDTO = new PeliculaBasicDTO();
			basicDTO.setId(entity.getId());
			basicDTO.setImagen(entity.getImagen());
			basicDTO.setTitulo(entity.getTitulo());
			basicDTO.setFechaCreacion(entity.getFechaCreacion());
			dtos.add(basicDTO);
		}
		
		return dtos;
	}
	
	public void entityRefreshValues(Pelicula pelicula, PeliculaDTO dto) {
		pelicula.setImagen(dto.getImagen());
		pelicula.setTitulo(dto.getTitulo());
		pelicula.setFechaCreacion(
				this.string2LocalDate(dto.getFechaCreacion())
		);
		pelicula.setCalificacion(dto.getCalificacion());
		pelicula.setGeneroId(dto.getGenero());
	}
	
	public List<Pelicula> toEntityList(List<PeliculaDTO> dtos){
		List<Pelicula> entities = new ArrayList<>();
		for (PeliculaDTO dto : dtos) {
			entities.add(this.toEntity(dto));
		}
		return entities;
	}
	
	//Parse the stringDate to LocalDate type.
	private LocalDate string2LocalDate(String stringDate) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate date = LocalDate.parse(stringDate, formatter);
		return date;
	}
	
}
