package com.example.springbootplayground.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootplayground.CSVReader;
import com.example.springbootplayground.resources.Distance;

@RestController
public class DistanceController {
	private CSVReader reader = new CSVReader("airports.dat.txt");
	
	@RequestMapping("/distances")
	@ResponseBody
	public Distance getDistance(
			@RequestParam(value="source") String source,
			@RequestParam(value="destination") String destination) {
		double[] srcCoords = reader.getCoordinates(source);
		double[] destCoords = reader.getCoordinates(destination);
		return new Distance(srcCoords, destCoords);
	}
}
