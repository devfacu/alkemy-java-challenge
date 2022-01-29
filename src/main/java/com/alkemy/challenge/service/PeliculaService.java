package com.alkemy.challenge.service;

import java.util.List;

import com.alkemy.challenge.dto.PeliculaBasicDTO;
import com.alkemy.challenge.dto.PeliculaDTO;

public interface PeliculaService {

	PeliculaDTO save(PeliculaDTO dto);
	
	PeliculaDTO update(PeliculaDTO dto);
	
	List<PeliculaBasicDTO> getAllPeliculasBasic();
	
	PeliculaDTO getDetailsById(String id);
	
	void deletePelicula(String id);
	
	List<PeliculaDTO> getByFilters(String name, String idGenero, String order);
}
