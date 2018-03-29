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
	
	@Bean
	public CommandLineRunner populate(AirportRepository repository) {
		return (args) -> {
			List<String[]> airports = reader.getAllRecords();
			
			for (String[] airport : airports) {
				repository.save(new Airport(airport[4], airport[1], airport[2], airport[3]));
			}
			
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (Airport a : repository.findAll()) {
				log.info(a.toString());
			}
			
		};
	}
	
	@RequestMapping("/")
	@ResponseBody
	String home() {
		//turn this into a service discovery endpoint
		return "Hello World!";
	}

	
}
