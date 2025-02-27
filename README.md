# Blog App APIs

This project is a RESTful Blog Application Backend built with Spring Boot, providing API services for user authentication, blog posts, comments, categories, and more.

## Author: Tuan Anh PHAM

### Features

- User Registration & Authentication (JWT-based)

- CRUD operations for Posts, Categories, Comments

- Role-based access control

- File Uploads

- Exception Handling

- Pagination and Sorting

- API Documentation with Swagger

### Tech Stack

- Java 21

- Spring Boot 3.4.1

- Spring Security

- Hibernate & JPA

- MySQL

- JWT Authentication

- Swagger (OpenAPI 2.8.5)

- Maven

- AWS RDS (MySQL)

- Render (Deployment)

### Configuration

Create a `application-prod.properties` file :

```
spring.datasource.url = jdbc:mysql://<DB_HOST>:<DB_PORT>/<DB_NAME>
spring.datasource.username = <DB_USERNAME>
spring.datasource.password = <DB_PASSWORD>
```

### Running Locally

Clone the repository

```
git clone https://github.com/tuananhfr/blog-app-apis.git
cd blog-app-apis
```

### Build the Project

```
./mvnw clean install
```

### Run the Application

```
java -jar target/blog-app-apis-0.0.1-SNAPSHOT.jar
```

The application will be available at: `http://localhost:5000`

### API Documentation

Swagger API documentation is available at:

```
http://localhost:8080/swagger-ui/index.html
```

### Deployment

The project is deployed on Render using the free tier.

Render Deployment URL:

```
https://blog-app-apis-lyf0.onrender.com/
```

### License

This project is licensed under the MIT License.
