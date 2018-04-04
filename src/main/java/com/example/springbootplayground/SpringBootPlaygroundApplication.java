package com.example.springbootplayground;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.springbootplayground.airport.Airport;
import com.example.springbootplayground.airport.AirportRepository;
import com.opencsv.CSVReader;

/**
 * The SpringBootPlaygroundApplication is a small RESTful API that gives end-users the ability to get airport information
 * based upon the airport's IATA code and to calculate the distance between two airport's using their IATA codes.
 * @author zhughes
 * @version 0.0.1
 *
 */
@SpringBootApplication
public class SpringBootPlaygroundApplication {
	
	private static final Logger log = LoggerFactory.getLogger(SpringBootPlaygroundApplication.class);
	private static CSVReader reader;
	private static String filename = "airports.dat.txt";
	
	
	public static void main(String[] args) {
		log.info("Working Directory =" + System.getProperty("user.dir"));
		try {
			reader = new CSVReader(new FileReader(filename));
		} catch (FileNotFoundException e) {
			System.out.println("File " + filename + " could not be found.");
		}
		SpringApplication.run(SpringBootPlaygroundApplication.class, args);
	}
	
	/**
	 * populate method populate's an in-memory H2 database with airline information from openflights.org
	 * @param repository
	 * @return
	 */
	@Bean
	public CommandLineRunner populate(AirportRepository repository) {
		return (args) -> {
			List<String[]> airports = reader.readAll();
			
			for (String[] airport : airports) {
				double lat = Double.parseDouble(airport[6]);
				double lng = Double.parseDouble(airport[7]);
				repository.save(new Airport(airport[4], airport[1], airport[2], airport[3], lat, lng));
				
			}
		};
	}
}
