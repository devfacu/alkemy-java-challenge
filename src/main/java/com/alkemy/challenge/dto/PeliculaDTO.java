package com.alkemy.challenge.dto;

import java.util.List;

public class PeliculaDTO {
	
	private String id;
	private String imagen;
	private String titulo;
	private String fechaCreacion;
	private Integer calificacion;
	private String genero;
	private List<PersonajeDTO> personajes;
	
	//Constructor
	public PeliculaDTO() {
	}

	
	//Getters & Setters
	public String getId() {
		return id;
	}

	public String getImagen() {
		return imagen;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getFechaCreacion() {
		return fechaCreacion;
	}

	public Integer getCalificacion() {
		return calificacion;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public void setCalificacion(Integer calificacion) {
		this.calificacion = calificacion;
	}

	public String getGenero() {
		return genero;
	}

	public List<PersonajeDTO> getPersonajes() {
		return personajes;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public void setPersonajes(List<PersonajeDTO> personajes) {
		this.personajes = personajes;
	}
	
}
