package com.alkemy.challenge.dto;

public class GeneroDTO {

	private String id;
	private String imagen;
	private String nombre;
	
	//Constructor
	public GeneroDTO() {
	}
	
	//Getters & Setters
	public String getId() {
		return id;
	}

	public String getImagen() {
		return imagen;
	}

	public String getNombre() {
		return nombre;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
