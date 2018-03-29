package com.example.springbootplayground.resources;

import com.example.springbootplayground.CSVReader;

public class Airport {
	private final String name;
	private final String city;
	private final String country;
	
	public Airport(CSVReader reader, String iata) {
		String[] airport_info = reader.getAirportInfo(iata);
		//return new Airport();
		if (airport_info.length != 3) {
			System.out.println("Error constructing an Airport object");
			this.name = null; this.city = null; this.country = null;
		} else {
			this.name = airport_info[0];
			this.city = airport_info[1];
			this.country = airport_info[2];
		}
	}
	
	public String getName() {
		return name;
	}
	
	public String getCity() {
		return city;
	}
	
	public String getCountry() {
		return country;
	}
	
	public String toString() {
		return this.name + ", " + this.city + ", " + this.country;
	}

}
