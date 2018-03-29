package com.example.springbootplayground;

public class Airport {
	private final String name;
	private final String city;
	private final String country;
	
	
	
	public Airport(String name, String city, String country) {
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
	
	public String toString() {
		return this.name + ", " + this.city + ", " + this.country;
	}

}
