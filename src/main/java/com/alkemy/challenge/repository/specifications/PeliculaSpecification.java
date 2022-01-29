package com.alkemy.challenge.repository.specifications;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.alkemy.challenge.dto.PeliculaFiltersDTO;
import com.alkemy.challenge.entity.Pelicula;

@Component
public class PeliculaSpecification {

	public Specification<Pelicula> getByFilters(PeliculaFiltersDTO filtersDTO) {
		return (root, query, criteriaBuilder) -> {
			
			List<Predicate> predicates = new ArrayList<>();
			
			if (StringUtils.hasLength(filtersDTO.getName())) {
				predicates.add(
						criteriaBuilder.like(
								criteriaBuilder.lower(root.get("titulo")),
								"%" + filtersDTO.getName().toLowerCase() + "%"
						)
				);
			}
			
			if (StringUtils.hasLength(filtersDTO.getIdGenero())) {
				predicates.add(
						criteriaBuilder.equal(root.get("generoId"), filtersDTO.getIdGenero())
				);
			}
			
			//Remove distinct
			query.distinct(true);
			
			//Order resolver
			String orderByField = "fechaCreacion";
			query.orderBy(
					filtersDTO.isASC() ?
							criteriaBuilder.asc(root.get(orderByField)) :
							criteriaBuilder.desc(root.get(orderByField))
			);
			
			return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
		};
	}
}
