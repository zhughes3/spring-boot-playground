package com.example.springbootplayground;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.springbootplayground.persistence.AirportRepository;
import com.example.springbootplayground.resources.Airport;


@SpringBootApplication
public class SpringBootPlaygroundApplication {
	
	private static final Logger log = LoggerFactory.getLogger(SpringBootPlaygroundApplication.class);
	private CSVReader reader = new CSVReader("airports.dat.txt");
	
	public static void main(String[] args) {
		log.info("Working Directory =" + System.getProperty("user.dir"));
		SpringApplication.run(SpringBootPlaygroundApplication.class, args);
	}
	
	//populate H2 database with Airport resources
	@Bean
	public CommandLineRunner populate(AirportRepository repository) {
		return (args) -> {
			List<String[]> airports = reader.getAllRecords();
			String regex = "^[0-9.]*$";
			
			for (String[] airport : airports) {
				if (airport[6].matches(regex) && airport[7].matches(regex)) {
					double lat = Double.parseDouble(airport[6]);
					double lng = Double.parseDouble(airport[7]);
					repository.save(new Airport(airport[4], airport[1], airport[2], airport[3], lat, lng));
				}
			}
			
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (Airport a : repository.findAll()) {
				log.info(a.toString());
			}
		};
	}
}
