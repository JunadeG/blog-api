# Spring Boot Blog API

A simple RESTful API for a multi-author blog built with Spring Boot. This project demonstrates a clean, layered architecture (Controller-Service-Repository) and JPA/Hibernate for database relationships.

## Technologies Used

*   Java 17 (or your JDK version)
*   Spring Boot 3.x
*   Spring Data JPA / Hibernate
*   PostgreSQL
*   Maven
*   Lombok

## Features

*   Create and view authors.
*   Create posts for a specific author.
*   View all posts.
*   Built with a clean Controller-Service-Repository architecture.
*   Demonstrates a `@ManyToOne` database relationship between Posts and Authors.

## Getting Started

To get a local copy up and running, follow these simple steps.

### Prerequisites

*   JDK 17 or higher
*   Maven 3.2+
*   A running instance of PostgreSQL

### Installation and Setup

1.  **Clone the repository**
    ```bash
    git clone https://github.com/JunadeG/blog-api.git
    ```
2.  **Navigate to the project directory**
    ```bash
    cd blog-api
    ```
3.  **Create the database**
    *   In your PostgreSQL client (e.g., pgAdmin), create a new, empty database named `blog_api_db`.

4.  **Create the `application.properties` file**
    *   Navigate to the `src/main/resources/` directory.
    *   Create a new file named `application.properties`.
    *   Add the following content to the file, replacing `your_db_password` with your own PostgreSQL password.
    ```properties
    server.port=8083

    # Database Connection Properties
    spring.datasource.url=jdbc:postgresql://localhost:5432/blog_api_db
    spring.datasource.username=postgres
    spring.datasource.password=your_db_password

    # Instruct Hibernate to automatically create/update tables
    spring.jpa.hibernate.ddl-auto=update
    ```

### Running the Application

*   You can run the application directly from your IDE by running the `BlogApiApplication.java` file.
*   Alternatively, you can build and run it from the command line using Maven:
  ```bash
  mvn spring-boot:run

## API Endpoints

### Authors

*   `GET /api/authors` - Retrieves a list of all authors.
*   `POST /api/authors` - Creates a new author.
    *   **Body:**
        ```json
        {
          "name": "string",
          "email": "string"
        }
        ```

### Posts

*   `GET /api/posts` - Retrieves a list of all posts.
*   `POST /api/authors/{authorId}/posts` - Creates a new post for a specific author.
    *   **Body:**
        ```json
        {
          "title": "string",
          "content": "string"
        }
        ```
