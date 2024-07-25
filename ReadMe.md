# FX Deal Tracker

## Overview

The FX Deal Tracker is a Spring Boot application that allows you to manage FX deals, including importing, saving, and handling duplicate deal requests. The application uses MySQL as its database and Docker Compose for container orchestration.

## Project Structure

- **`src/main/java/com/example/analyzeFXDeal/`**: Contains the main Java source files, including entity classes, repositories, services, controllers, and exception handlers.
- **`src/test/java/com/example/analyzeFXDeal/`**: Contains unit tests for the application, including tests for controllers and services.
- **`Dockerfile`**: Defines the Docker image for the Spring Boot application.
- **`docker-compose.yml`**: Defines the Docker Compose configuration for the MySQL database and the Spring Boot application.

## Prerequisites

- Docker
- Docker Compose
- Maven

## Setup

1. **Clone the Repository**

   git clone https://github.com/your-repo/analyzeFXDeal.git
   cd analyzeFXDeal


- Build the Project:
   ```properties
   mvn clean package
   ```
- Build and Start Containers

   ```properties
   docker-compose up --build
   ```
## Docker Configuration

1. Dockerfile
 
   The Dockerfile
      builds an image for the Spring Boot application:
    ```bash
     FROM maven:3.8.3-openjdk-17

      WORKDIR /analyzeFXDeal
      
      COPY /target/*.jar ./java.jar
      
      EXPOSE 8080
      
      CMD ["java", "-jar", "java.jar"]
      ```
   2 **docker-compose.yml**
      ```bash
      version: '3.8'
      services:
      mysqldb:
      image: mysql:latest
      environment:
      MYSQL_DATABASE: fxdeals_tracker
      MYSQL_USER: fXDealUser
      MYSQL_PASSWORD: fXDealUser11
      MYSQL_ROOT_PASSWORD: root
      ports:
      - "3306:3306"
      
      application:
      depends_on:
      - mysqldb
      build: .
      ports:
        - "8080:8080"
        environment:
        spring.datasource.url: jdbc:mysql://mysqldb:3306/fxdeals_tracker
        spring.datasource.username: fXDealUser
        spring.datasource.password: fXDealUser11
      
     ```

## API Endpoints
Import FX Deal
- Endpoint: POST /api/add/fxdeal
- Request Body should be like this:
   ```bash
  {
  "dealUniqueId": 123,
  "fromCurrencyISOCode": "USD",
  "toCurrencyISOCode": "EUR",
  "dealTimestamp": "2024-07-25T14:00:00",
  "dealAmount": 1000.00
   }
  ```
## Exception Handling
- The application uses global exception handling to manage FxDealSameRequest exceptions, which indicates that a deal with the same unique ID already exists.
## Running Tests
 - To run unit tests:
   ```bash
   mvn test
   ```
## Notes
- Ensure Docker and Docker Compose are installed and running.
- The MySQL database is exposed on port 3306, and the Spring Boot application is exposed on port 8080.