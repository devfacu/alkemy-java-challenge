package com.alkemy.challenge.dto;

public class PeliculaFiltersDTO {
	
	private String name;
	private String idGenero;
	private String order;
	
	
	public PeliculaFiltersDTO() {
	}

	public PeliculaFiltersDTO(String name, String idGenero, String order) {
		this.name = name;
		this.idGenero = idGenero;
		this.order = order;
	}

	public String getName() {
		return name;
	}

	public String getIdGenero() {
		return idGenero;
	}

	public String getOrder() {
		return order;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setIdGenero(String idGenero) {
		this.idGenero = idGenero;
	}

	public void setOrder(String order) {
		this.order = order;
	}
	
	public boolean isASC() {return this.order.compareToIgnoreCase("ASC") == 0;}
	
}
