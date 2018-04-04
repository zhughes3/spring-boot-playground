package com.example.springbootplayground.distance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * The DistanceController routes HTTP methods to the /distances endpoint. With this endpoint, an end-user can quickly
 * calculate the distance between two airports using their respective IATA codes.
 * @author zhughes
 *
 */
@RestController
public class DistanceController {
	@Autowired
	private DistanceService distanceService;
	
	/**
	 * getDistance calculates the distance between two airports based upon their lat/long coordinates.
	 * @param source Source airport's IATA code.
	 * @param destination Destination airport's IATA code.
	 * @return
	 */
	@GetMapping("/distances")
	@ResponseBody
	public Distance getDistance(
			@RequestParam(value="source") String source,
			@RequestParam(value="destination") String destination) {
		return distanceService.getDistance(source, destination);
	}
}
