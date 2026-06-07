# Student Management System

A Spring Boot REST API for managing student records with JWT Authentication and MySQL database integration.

## Features

- Student CRUD Operations
- Search Students by Name
- Search Students by Department
- Pagination and Sorting
- Global Exception Handling
- Input Validation
- Swagger API Documentation
- User Registration
- User Login
- Password Encryption using BCrypt
- JWT Authentication
- MySQL Database Integration

## Tech Stack

- Java 17
- Spring Boot 3
- Spring Security
- Spring Data JPA
- MySQL
- JWT
- Maven
- Swagger/OpenAPI
- Git & GitHub

## API Endpoints

### Authentication

POST /auth/register

POST /auth/login

### Student Management

GET /students

GET /students/{id}

POST /students

PUT /students/{id}

DELETE /students/{id}

### Search

GET /students/search/name?name=Teja

GET /students/search/department?department=AI&DS

### Pagination

GET /students/paginated?page=0&size=5&sortBy=name

## Database

MySQL Database: student_management

Tables:
- students
- users

## Swagger Documentation

http://localhost:8080/swagger-ui/index.html

## Future Enhancements

- JWT Authorization Filter
- Role Based Access Control (ADMIN/USER)
- Unit Testing
- Docker Support
- React Frontend
- Deployment

## Author

Naramala Kumarteja

LinkedIn:
www.linkedin.com/in/naramalakumarteja
