package com.example.springbootplayground.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootplayground.CSVReader;
import com.example.springbootplayground.resources.Airport;


@RestController
public class AirportController {
//	@Value("${csv.path}")
//	private String csvPath;
//	
//	private CSVReader reader = new CSVReader(csvPath);
	private CSVReader reader = new CSVReader("airports.dat.txt");
	
	@RequestMapping("/airports")
	@ResponseBody
	public Airport getAirport(@RequestParam(value="iata") String iata) {
		return new Airport(reader, iata);
	}

}
