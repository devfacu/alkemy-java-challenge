package com.alkemy.challenge.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonajeDTO {
	
	private String id;
	private String imagen;
	private String nombre;
	private Integer edad;
	private Integer peso;
	private String historia;
	
	public PersonajeDTO(){
	}

}
