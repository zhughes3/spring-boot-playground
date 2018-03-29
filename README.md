# spring-boot-playground

## Packages

### SpringBootPlayground

#### SpringBootPlaygroundApplication

Main class for creating the Spring Boot Application.

#### CSVReader

Basic wrapper class for working with the database of Airports from https://openflights.org/data.html

The records are stored locally in a CSV file.

### Resources

#### Airport

Class that contains resource-level data for an airport. Currently maintains information about name, city and state.

#### Distance

Class that contains resource-level data for distances between two airports.

### Controllers

#### AirportController

Spring REST Controller class that handles routing for /airports path.

#### DistanceController

Spring REST Controller class that handles routing for /distances path.

