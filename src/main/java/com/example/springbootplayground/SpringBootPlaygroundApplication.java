package com.example.springbootplayground;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@Controller
@EnableAutoConfiguration
public class SpringBootPlaygroundApplication {
	
	@RequestMapping("/")
	@ResponseBody
	String home() {
		return "Hello World!";
	}
	
	@RequestMapping("/airports")
	@ResponseBody
	public Airport getAirport(@RequestParam(value="iata") String iata) {
		//from csv get iata
		String[] airport_info = getAirportInfo(iata);
		//return new Airport();
		if (airport_info.length != 3) {
			//return "error with iata= " + iata;
			return null;
		} else {
			return new Airport(airport_info[0], airport_info[1], airport_info[2]);
			//return airport_info[0] +", " + airport_info[1] + ", " + airport_info[2];
		}
	}
	
	@RequestMapping("/distances")
	@ResponseBody
	public Distance getDistance(@RequestParam(value="source") String source,
			@RequestParam(value="destination") String destination) {
		double[] srcCoords = getCoordinates(source);
		double[] destCoords = getCoordinates(destination);
		return new Distance(srcCoords, destCoords);
	}
	
	//return name, city, country
	private String[] getAirportInfo(String iata)  {
		BufferedReader reader = null; 
		String line = null;
		String[] returnArr = new String[3];
		try {
			reader = new BufferedReader(new FileReader("airports.dat.txt"));
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
				String[] fields = cleanLine(line.split(","));
				if (fields[4].equals(iata)) {
					returnArr[0] = fields[1];
					returnArr[1] = fields[2];
					returnArr[2] = fields[3];
					return returnArr;
				}
			}
		} catch (FileNotFoundException e) {
			
		} catch (IOException e) {
			
		} 
		return null;
	}
	
	private double[] getCoordinates(String iata) {
		BufferedReader reader = null; 
		String line = null;
		double[] returnArr = new double[2];
		try {
			reader = new BufferedReader(new FileReader("airports.dat.txt"));
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
				String[] fields = cleanLine(line.split(","));
				if (fields[4].equals(iata)) {
					returnArr[0] = Double.valueOf(fields[6]);
					returnArr[1] = Double.valueOf(fields[7]);
					return returnArr;
				}
			}
		} catch (FileNotFoundException e) {
			
		} catch (IOException e) {
			
		} 
		return null;
	}
	
	private String[] cleanLine(String[] line) {
		String[] returnArr = new String[line.length];
		for (int i = 0; i < line.length; i++) {
			String field = line[i];
			if (field.startsWith("\"") && field.endsWith("\"")) {
				returnArr[i] = field.substring(1, field.length()-1);
			} else {
				returnArr[i] = field;
			}
		}
		return returnArr;
	}

	public static void main(String[] args) {
		System.out.println("Working Directory =" + System.getProperty("user.dir"));
		SpringApplication.run(SpringBootPlaygroundApplication.class, args);
	}
}
