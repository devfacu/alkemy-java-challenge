package com.alkemy.challenge.repository.specifications;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.alkemy.challenge.dto.PersonajeFiltersDTO;
import com.alkemy.challenge.entity.Pelicula;
import com.alkemy.challenge.entity.Personaje;

@Component
public class PersonajeSpecification {

	public Specification<Personaje> getByFilters(PersonajeFiltersDTO filtersDTO) {
		return (root, query, criteriaBuilder) -> {
			
			List<Predicate> predicates = new ArrayList<>();
			
			if (StringUtils.hasLength(filtersDTO.getName())) {
				predicates.add(
						criteriaBuilder.like(
								criteriaBuilder.lower(root.get("nombre")),
								"%" + filtersDTO.getName().toLowerCase() + "%"
						)
				);
			}
			
			if (StringUtils.hasLength(filtersDTO.getAge())) {
				Integer age = Integer.parseInt(filtersDTO.getAge());
				
				predicates.add(
						criteriaBuilder.equal(root.get("edad"), age)
				);
			}
			
			if (!CollectionUtils.isEmpty(filtersDTO.getMovies())) {
				Join<Pelicula, Personaje> join = root.join("peliculas", JoinType.INNER);
				Expression<String> moviesId = join.get("id");
				predicates.add(moviesId.in(filtersDTO.getMovies()));
			}
			
			//Remove distinct
			query.distinct(true);
			
			//Order resolver
			String orderByField = "nombre";
			query.orderBy(
					filtersDTO.isASC() ?
							criteriaBuilder.asc(root.get(orderByField)) :
							criteriaBuilder.desc(root.get(orderByField))
			);
			
			return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
		};
	}
}
