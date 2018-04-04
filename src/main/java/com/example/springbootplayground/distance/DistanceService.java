package com.example.springbootplayground.distance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springbootplayground.airport.Airport;
import com.example.springbootplayground.airport.AirportRepository;

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
