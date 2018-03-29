package com.example.springbootplayground.persistence;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.springbootplayground.resources.Airport;

public interface AirportRepository extends CrudRepository<Airport, Long>{
	List<Airport> findByIata(String iata);
}
