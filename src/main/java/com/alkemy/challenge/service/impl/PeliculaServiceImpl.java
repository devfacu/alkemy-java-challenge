package com.alkemy.challenge.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alkemy.challenge.dto.PeliculaBasicDTO;
import com.alkemy.challenge.dto.PeliculaDTO;
import com.alkemy.challenge.dto.PeliculaFiltersDTO;
import com.alkemy.challenge.entity.Pelicula;
import com.alkemy.challenge.entity.Personaje;
import com.alkemy.challenge.mapper.PeliculaMapper;
import com.alkemy.challenge.mapper.PersonajeMapper;
import com.alkemy.challenge.repository.PeliculaRepository;
import com.alkemy.challenge.repository.specifications.PeliculaSpecification;
import com.alkemy.challenge.service.PeliculaService;

@Service
public class PeliculaServiceImpl implements PeliculaService {

	@Autowired
	private PeliculaRepository peliculaRepo;
	
	@Autowired
	private PeliculaMapper peliculaMapper;
	
	@Autowired
	private PersonajeMapper personajeMapper;
	
	@Autowired
	private PeliculaSpecification peliculaSpec;
	
	public PeliculaDTO save(PeliculaDTO dto) {
		Pelicula pelicula = this.peliculaMapper.toEntity(dto);
		try {
			if (!dto.getPersonajes().isEmpty()) {
				List<Personaje> personajes = this.personajeMapper.toEntityList(dto.getPersonajes());
				pelicula.setPersonajes(personajes);
			}
		} catch (Exception e) {
			//Do Nothing
		}
		Pelicula peliculaSaved = peliculaRepo.save(pelicula);
		PeliculaDTO result = this.peliculaMapper.toDTO(peliculaSaved, false);
		return result;
	}
	
	public PeliculaDTO update(PeliculaDTO dto) {
		Pelicula pelicula = this.peliculaRepo.getById(dto.getId());
		this.peliculaMapper.entityRefreshValues(pelicula, dto);
		try {
			if (!dto.getPersonajes().isEmpty()) {
				List<Personaje> personajes = this.personajeMapper.toEntityList(dto.getPersonajes());
				pelicula.setPersonajes(personajes);
			}
		} catch (Exception e) {
			//Do Nothing
		}
		this.peliculaRepo.save(pelicula);
		return dto;
	}
	
	
	public PeliculaDTO getDetailsById(String id) {
		Pelicula pelicula = peliculaRepo.getById(id);
		PeliculaDTO dto = peliculaMapper.toDTO(pelicula, true);
		return dto;
	}
	
	public List<PeliculaBasicDTO> getAllPeliculasBasic(){
		List<Pelicula> entities = peliculaRepo.findAll();
		List<PeliculaBasicDTO> dtos = peliculaMapper.toBasicDTOList(entities);
		return dtos;
	}
	
	public List<PeliculaDTO> getByFilters(String name, String idGenero, String order) {
		PeliculaFiltersDTO filtersDTO = new PeliculaFiltersDTO(name, idGenero, order);
		List<Pelicula> entities = peliculaRepo.findAll(peliculaSpec.getByFilters(filtersDTO));
		List<PeliculaDTO> dtos = peliculaMapper.toDTOList(entities, true);
		return dtos;
	}	

	public void deletePelicula(String id) {
		peliculaRepo.deleteById(id);
	}

}
