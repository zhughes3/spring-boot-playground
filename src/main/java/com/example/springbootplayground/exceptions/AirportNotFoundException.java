package com.example.springbootplayground.exceptions;

public class AirportNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;

	public AirportNotFoundException(String message) {
		super(message);
	}
}
