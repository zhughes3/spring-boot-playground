package com.example.springbootplayground.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springbootplayground.persistence.AirportRepository;
import com.example.springbootplayground.resources.Airport;
import com.example.springbootplayground.resources.Distance;

@Service
public class DistanceService {
	@Autowired
	private AirportRepository repository;
	
	public Distance getDistance(String source, String destination) {
		Airport sourceAirport = repository.findByIata(source);
		Airport destAirport = repository.findByIata(destination);
		return new Distance(sourceAirport.getLatitude(), sourceAirport.getLongitude(), destAirport.getLatitude(), destAirport.getLongitude());
	}
}
