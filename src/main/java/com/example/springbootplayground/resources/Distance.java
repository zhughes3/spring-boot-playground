package com.example.springbootplayground.resources;

public class Distance {
	double distance;
	
	public Distance(double[] srcCoords, double[] destCoords) {
		setDistance(srcCoords[0], srcCoords[1], destCoords[0], destCoords[1], 0, 0);
	}
	
	public Distance(double srcLat, double srcLong, double destLat, double destLong) {
		setDistance(srcLat, srcLong, destLat, destLong, 0, 0);
	}
	
	public double getDistance() {
		return this.distance;
	}
	
	// https://stackoverflow.com/questions/3694380/calculating-distance-between-two-points-using-latitude-longitude-what-am-i-doi
	// calculate distance between two lat/long coordinates
	private void setDistance(double lat1, double lat2, double lon1,
	        double lon2, double el1, double el2) {

	    final int R = 6371; // Radius of the earth

	    double latDistance = Math.toRadians(lat2 - lat1);
	    double lonDistance = Math.toRadians(lon2 - lon1);
	    double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
	            + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
	            * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
	    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
	    double distance = R * c * 1000; // convert to meters

	    double height = el1 - el2;

	    distance = Math.pow(distance, 2) + Math.pow(height, 2);

	    this.distance = Math.sqrt(distance);
	}

}
