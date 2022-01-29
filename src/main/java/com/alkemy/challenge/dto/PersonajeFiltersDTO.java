package com.alkemy.challenge.dto;

import java.util.List;

public class PersonajeFiltersDTO {
	
	private String name;
	private String age;
	private List<String> movies;
	private String order;
	
	public PersonajeFiltersDTO() {
		
	}
	
	public PersonajeFiltersDTO(String name, String age, List<String> movies, String order) {
		this.name = name;
		this.age = age;
		this.movies = movies;
		this.order = order;
	}

	public String getName() {
		return name;
	}


	public String getAge() {
		return age;
	}


	public List<String> getMovies() {
		return movies;
	}


	public String getOrder() {
		return order;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setAge(String age) {
		this.age = age;
	}


	public void setMovies(List<String> movies) {
		this.movies = movies;
	}


	public void setOrder(String order) {
		this.order = order;
	}
	
	public boolean isASC() {return this.order.compareToIgnoreCase("ASC") == 0;}
	
	public boolean idDESC() {return this.order.compareToIgnoreCase("DESC") == 0;}
	
}
