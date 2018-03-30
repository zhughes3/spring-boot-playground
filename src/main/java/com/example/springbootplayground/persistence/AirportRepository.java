package com.example.springbootplayground.persistence;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.springbootplayground.resources.Airport;

@RepositoryRestResource(collectionResourceRel = "airports", path = "airports")
public interface AirportRepository extends PagingAndSortingRepository<Airport, Long> {
	
	List<Airport> findByIata(@Param("iata") String iata);
	
}
