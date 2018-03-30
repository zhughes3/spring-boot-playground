package com.example.springbootplayground.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootplayground.persistence.AirportRepository;
import com.example.springbootplayground.resources.Airport;
import com.example.springbootplayground.resources.Distance;

@RestController
public class DistanceController {
	
	@Autowired
	private AirportRepository repository;
	
	@RequestMapping("/distances")
	@ResponseBody
	public Distance getDistance(
			@RequestParam(value="source") String source,
			@RequestParam(value="destination") String destination) {
		Airport sourceAirport = repository.findByIata(source);
		Airport destAirport = repository.findByIata(destination);
		return new Distance(sourceAirport.getLatitude(), sourceAirport.getLongitude(), destAirport.getLatitude(), destAirport.getLongitude());
	}
}
