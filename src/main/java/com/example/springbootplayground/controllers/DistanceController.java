package com.example.springbootplayground.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootplayground.persistence.AirportRepository;
import com.example.springbootplayground.resources.Airport;
import com.example.springbootplayground.resources.Distance;

/**
 * The DistanceController routes HTTP methods to the /distances endpoint. With this endpoint, an end-user can quickly
 * calculate the distance between two airports using their respective IATA codes.
 * @author zhughes
 *
 */
@RestController
public class DistanceController {
	
	@Autowired
	private AirportRepository repository;
	
	
	/**
	 * getDistance calculates the distance between two airports based upon their lat/long coordinates.
	 * @param source Source airport's IATA code.
	 * @param destination Destination airport's IATA code.
	 * @return
	 */
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
