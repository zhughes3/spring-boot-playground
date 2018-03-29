# spring-boot-playground

## Packages

### SpringBootPlayground

	1. SpringBootPlaygroundApplication

Main class for creating the Spring Boot Application.

	2. CSVReader

Basic wrapper class for working with the database of Airports from https://openflights.org/data.html

The records are stored locally in a CSV file.

### Resources

	1. Airport

Class that contains resource-level data for an airport. Currently maintains information about name, city and state.

	2. Distance

Class that contains resource-level data for distances between two airports.

### Controllers

	1. AirportController

Spring REST Controller class that handles routing for /airports path.

	2. DistanceController

Spring REST Controller class that handles routing for /distances path.

