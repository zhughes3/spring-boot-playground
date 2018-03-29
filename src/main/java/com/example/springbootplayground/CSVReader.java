package com.example.springbootplayground;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {
	BufferedReader reader;
	
	public CSVReader(String filename) {
		try {
			reader = new BufferedReader(new FileReader(filename));
		} catch (FileNotFoundException e) {
			System.out.println("File " + filename + " could not be found.");
		}
	}
	
	public List<String[]> getAllRecords() {
		List<String[]> records = new ArrayList<>();
		String line = null;
		try {
			while ((line = reader.readLine()) != null) {
				String[] fields = cleanLine(line.split(","));
				records.add(fields);
			}
		} catch (IOException e) {
			System.out.println("Encountered an IOException while trying to get all records.");
		} 
		return records;
	}
	
	// return name, city, country
	public String[] getAirportInfo(String iata) {
		String line = null;
		String[] returnArr = new String[3];
		try {
			while ((line = reader.readLine()) != null) {
				String[] fields = cleanLine(line.split(","));
				if (fields[4].equals(iata)) {
					//found the record with correct IATA code
					returnArr[0] = fields[1];
					returnArr[1] = fields[2];
					returnArr[2] = fields[3];
					return returnArr;
				}
			}
		} catch (IOException e) {
			System.out.println("Encountered an IOException while trying to find airport info.");
		} 
		
		return null;
	}
	
	// return latitude and longitude coordinates
	public double[] getCoordinates(String iata) {
		String line = null;
		double[] returnArr = new double[2];
		try {
			while ((line = reader.readLine()) != null) {
				String[] fields = cleanLine(line.split(","));
				if (fields[4].equals(iata)) {
					returnArr[0] = Double.valueOf(fields[6]);
					returnArr[1] = Double.valueOf(fields[7]);
					return returnArr;
				}
			}
		} catch (IOException e) {
			System.out.println("Encountered an IOException while trying to find coordinates.");
		} 
		return null;
	}
	
	// helper method to scrub strings of leading and trailing double-quotes
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

}
