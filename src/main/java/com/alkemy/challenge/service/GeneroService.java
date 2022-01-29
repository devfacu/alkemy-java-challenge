package com.alkemy.challenge.service;

import java.util.List;

import com.alkemy.challenge.dto.GeneroDTO;

public interface GeneroService {
	
	
	GeneroDTO save(GeneroDTO dto);
	
	GeneroDTO update(GeneroDTO dto);
	
	List<GeneroDTO> getAll();
	
	void delete(String id);

	GeneroDTO getById(String id);
}
