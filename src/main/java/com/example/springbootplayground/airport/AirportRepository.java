package com.example.springbootplayground.airport;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * AirportRepository is an interface that helps Spring Boot build an implementation that allows for CRUD functionality for all of the
 * Airports in the database.
 * @author zhughes
 *
 */
@RepositoryRestResource(collectionResourceRel = "airports", path = "airports")
public interface AirportRepository extends PagingAndSortingRepository<Airport, Long> {
	Airport findByIata(@Param("iata") String iata);
}
