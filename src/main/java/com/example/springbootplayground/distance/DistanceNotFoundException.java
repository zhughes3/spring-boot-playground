package com.example.springbootplayground.distance;

public class DistanceNotFoundException extends Exception {
	
	public DistanceNotFoundException(String source, String destination) {
		super(String.format("Distance not found with source=%s and destination=%s", source, destination));
	}

}
