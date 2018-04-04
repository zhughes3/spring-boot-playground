package com.example.springbootplayground.airport;

public class AirportNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;

	public AirportNotFoundException(String message) {
		super(message);
	}
}
