# spring-boot-playground

## Packages

### SpringBootPlayground

<dl>
	<dt>SpringBootPlaygroundApplication</dt>
	<dd>Main class for creating the Spring Boot Application.</dd>
	<dt>CSVReader</dt>
	<dd>Basic wrapper class for working with the database of Airports from https://openflights.org/data.html. The records are stored locally in a CSV file.</dd>
</dl>

### Resources
<dl>
	<dt>Airport</dt>
	<dd>Class that contains resource-level data for an airport. Currently maintains information about name, city and state.</dd>
	<dt>Distance</dt>
	<dd>Class that contains resource-level data for distances between two airports.</dd>
</dl>

### Controllers

<dl>
	<dt>DistanceController</dt>
	<dd>Spring REST Controller class that handles routing for /distances path.</dd>
</dl>

### Persistence

<dl>
	<dt>AirportRepository</dt>
	<dd>Spring Repository interface that wires REST endpoints to the '/airports' path. Allows you to search Airports by IATA code.</dd>

</dl>

