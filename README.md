Project Report: Movie Watchlist CRUD Application Using Spring Boot
________________________________________
1. Introduction
The entertainment industry continues to grow rapidly with a never-ending stream of movies and series. Managing one's watchlist manually can become inefficient and frustrating. This project report details the development of a "Movie Watchlist" application, a simple yet highly educational Spring Boot-based CRUD application. The primary objective of this project is to demonstrate how to use Spring Boot with Maven to develop RESTful services that can perform Create, Read, Update, and Delete operations on a list of movies.
This project was developed as a learning experience to understand the architecture of Spring Boot applications, how RESTful APIs work, and how to integrate an in-memory database like H2 for development and testing purposes. The application is intended for personal use to manage movies, keep track of watched or unwatched titles, and record personal ratings and comments.
________________________________________
2. Project Objectives
The core objectives of this project are as follows:
•	Design and develop a RESTful web application using Spring Boot.
•	Implement full CRUD (Create, Read, Update, Delete) operations for movie data.
•	Store movie information such as title, genre, rating, watch status, and comments.
•	Use H2, an in-memory database, for development and testing.
•	Practice modular project structure with clear separation of concerns.
•	Enable and use the H2 database console for interactive queries.
•	Prepare the project for potential future expansion to include features like user authentication, filtering, sorting, and persistent databases.
________________________________________
3. Tools and Technologies Used
The following tools, technologies, and frameworks were used to develop and test the project:
Technology	Description
Java 17	Programming language used for development
Spring Boot 3.x	Java-based framework to simplify backend development
Maven	Project build and dependency management tool
Spring Data JPA	To handle database operations and ORM (Object-Relational Mapping)
H2 Database	Lightweight in-memory database used for testing and development
REST Client (VS Code)	Extension to test API endpoints directly from Visual Studio Code
VS Code	Lightweight code editor used to write, build, and run the project
Lombok	Java library to reduce boilerplate code like getters and constructors
________________________________________
4. Project Structure
The application follows the Model-Repository-Controller pattern for clean separation of concerns. The file structure is as follows:
src/main/java/com/nix/moviewatchlist/
├── MovieWatchlistApplication.java          # Main Spring Boot application file
├── controller/
│   └── MovieController.java                # REST endpoints for movie operations
├── model/
│   └── Movie.java                          # Entity class mapped to the database
└── repository/
    └── MovieRepository.java                # Repository interface extending JpaRepository

src/main/resources/
└── application.properties                  # Configuration file for Spring Boot and H2 console
This structure ensures maintainability and ease of testing.
________________________________________
5. Implementation Details
5.1 Movie Entity (Model Layer)
The Movie class is annotated with @Entity, indicating that it should be mapped to a database table. It contains the following fields:
•	id: Primary key, automatically generated.
•	title: The name of the movie.
•	genre: The category (e.g., Action, Comedy).
•	rating: A double representing the user's personal rating.
•	watched: A boolean indicating whether the movie has been watched.
•	comments: Any notes or remarks by the user.
Lombok annotations like @Data, @NoArgsConstructor, and @AllArgsConstructor are used to generate getter/setter methods and constructors automatically.
5.2 Repository Layer
MovieRepository is a simple interface extending JpaRepository. By doing so, it inherits all basic CRUD operations like save, findAll, findById, deleteById, etc. This minimizes boilerplate code and promotes rapid development.
5.3 Controller Layer
The MovieController class is annotated with @RestController and provides REST endpoints for CRUD operations. The @RequestMapping("/movies") annotation sets the base path for the endpoints. Here are the core endpoints:
•	GET /movies: Retrieves all movie records.
•	GET /movies/{id}: Retrieves a movie by its ID.
•	POST /movies: Adds a new movie to the watchlist.
•	PUT /movies/{id}: Updates an existing movie.
•	DELETE /movies/{id}: Deletes a movie.
Dependency injection is used to inject MovieRepository using the @Autowired annotation.
5.4 Configuration Layer
The application.properties file is used to enable the H2 console and configure database connection settings. Below is the configuration:
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=update
This configuration allows the user to connect to the H2 console and perform SQL queries interactively.
________________________________________
6. Testing and Output
The application was tested using the following methods:
1.	Browser Testing: A GET request to http://localhost:8080/movies returns an empty list [] when no records exist.
2.	H2 Console: Accessed at http://localhost:8080/h2-console using the JDBC URL jdbc:h2:mem:testdb. Used to insert and view data using raw SQL.
3.	VS Code REST Client (Optional): HTTP requests were created and tested using an .http file.
Sample SQL Insert Command:
INSERT INTO MOVIE (title, genre, rating, watched, comments)
VALUES ('Spirited Away', 'Fantasy', 9.1, TRUE, 'Loved the animation');
Sample JSON Response for GET /movies
[
  {
    "id": 1,
    "title": "Spirited Away",
    "genre": "Fantasy",
    "rating": 9.1,
    "watched": true,
    "comments": "Loved the animation"
  }
]
These tests confirm that the API works as expected, storing and retrieving movie data correctly.
________________________________________
7. Conclusion
This project offered a hands-on opportunity to explore the fundamentals of backend web development using Java and Spring Boot. By building a functional CRUD application, the project covered several key concepts:
•	Understanding and structuring a Spring Boot project
•	Creating entity classes and mapping them to tables using JPA
•	Implementing RESTful services for resource manipulation
•	Using H2 in-memory database for rapid testing and development
•	Testing endpoints using browser, REST Client, and H2 console
The project served as a foundational step for any future enterprise-level backend development involving more complex systems and permanent databases.
________________________________________
8. Future Enhancements
To make the application more robust and user-friendly, the following enhancements are proposed:
•	Database Migration: Replace H2 with a persistent database like MySQL or PostgreSQL for data permanence.
•	User Authentication: Introduce user login and registration so users can have their personal watchlists.
•	Search and Filter: Implement features to filter movies by genre, watched status, or rating.
•	Pagination and Sorting: Add pagination to handle large data sets efficiently.
•	Frontend Integration: Build a UI using React.js, Vue.js, or Angular to make the app more interactive.
•	Swagger UI: Add Swagger documentation to visualize and test endpoints easily.
•	Unit Testing: Integrate JUnit and Mockito for testing controllers and services.
________________________________________
9. References
•	Spring Boot Documentation: https://spring.io/projects/spring-boot
•	H2 Database: https://www.h2database.com
•	Spring Data JPA Guide: https://docs.spring.io/spring-data/jpa/docs/current/reference/html/
•	REST API Design: https://restfulapi.net/
•	Maven Official Site: https://maven.apache.org
________________________________________
