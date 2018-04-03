package com.example.springbootplayground.resources;

/**
 * Distance class maintains distance information between two airports.
 * @author zhughes
 *
 */
public class Distance {
	private double distance;
	final double RADIUS_OF_EARTH = 6372.8; //in kilometers
	enum Unit {
		MILES, METERS, KILOMETERS
	}
	Unit unit = Unit.MILES;
	
	public Distance(double[] srcCoords, double[] destCoords) {
		setDistance(srcCoords[0], srcCoords[1], destCoords[0], destCoords[1]);
	}
	
	public Distance(double srcLat, double srcLong, double destLat, double destLong) {
		setDistance(srcLat, srcLong, destLat, destLong);
	}
	
	public double getDistance() {
		return this.distance;
	}
	
	public Unit getUnit() {
		return this.unit;
	}
	
	/**
	 * setDistance uses the radius of the earth, elevation information and lat/long coordinates of two locations to calculate the distance between
	 * the two locations.
	 * 
	 * @param lat1
	 * @param lat2
	 * @param lon1
	 * @param lon2
	 * @param el1
	 * @param el2
	 */
	// calculate distance between two lat/long coordinates
	private void setDistance(double srcLat, double srcLong, double destLat, double destLong) {
	   distance = haversine(srcLat, srcLong, destLat, destLong);
	}
	
	private double haversine(double lat1, double long1, double lat2, double long2) {
		double dLat = Math.toRadians(lat2-lat1);
		double dLong = Math.toRadians(long2 - long1);
		
		lat1 = Math.toRadians(lat1);
		lat2 = Math.toRadians(lat2);
		
		double a = Math.pow(Math.sin(dLat / 2),2) + Math.pow(Math.sin(dLong / 2),2) * Math.cos(lat1) * Math.cos(lat2);
		double c = 2 * Math.asin(Math.sqrt(a));
		if (unit == Unit.MILES) {
			return (RADIUS_OF_EARTH * c)/1.609344;
		} else if (unit == Unit.METERS) {
			return RADIUS_OF_EARTH * c * 1000;
		} else if (unit == Unit.KILOMETERS) {
			return RADIUS_OF_EARTH * c;
		}
		
		return 0.0;
	}

}
