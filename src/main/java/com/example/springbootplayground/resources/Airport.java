package com.example.springbootplayground.resources;

import com.example.springbootplayground.CSVReader;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Airport {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String name;
	private String city;
	private String country;
	private String iata;
	
	protected Airport() { } 
	
	public Airport(CSVReader reader, String iata) {
		this.iata = iata;
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
	
	public Airport(String iata, String name, String city, String country) {
		this.iata = iata;
		this.name = name;
		this.city = city;
		this.country = country;
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
	
	public Long getId() {
		return id;
	}
	
	public String toString() {
		return this.name + ", " + this.city + ", " + this.country;
	}

}
