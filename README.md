# Spring Boot WebClient

A simple Spring Boot Microservices project demonstrating **inter-service communication using Spring WebClient**.

This project consists of two microservices:

- **User Service (Provider)**
- **Product Service (Consumer)**

The Product Service consumes the User Service REST API using **Spring WebClient** and returns the response to the client.

---

# Architecture

```
                Client
                   │
                   ▼
        Product Service (8082)
                   │
              WebClient
                   │
         HTTP REST Request
                   │
                   ▼
          User Service (8081)
                   │
             Returns JSON
```

---

# Technologies Used

- Java
- Spring Boot
- Spring WebClient
- Spring MVC
- Lombok
- Maven
- REST APIs

---

# Project Structure

```
WebClient
│
├── user-service
│
└── product-service
```

### User Service

```
user-service
│
├── controller
├── service
├── model
├── resources
└── UserServiceApplication
```

### Product Service

```
product-service
│
├── controller
├── service
├── config
├── dto
├── resources
└── ProductServiceApplication
```

---

# Features

- Spring Boot Microservices
- Spring WebClient
- REST API Communication
- Layered Architecture
- DTO Mapping
- Constructor Injection
- Externalized Configuration
- Lombok
- Clean Code

---

# API Endpoints

## User Service

```
GET /users/{id}
```

Example

```
GET http://localhost:8081/users/1
```

Response

```json
{
    "id":1,
    "name":"Aditya"
}
```

---

## Product Service

```
GET /products/user/{id}
```

Example

```
GET http://localhost:8082/products/user/1
```

Internally this endpoint calls

```
GET http://localhost:8081/users/1
```

using Spring WebClient.

Response

```json
{
    "id":1,
    "name":"Aditya"
}
```

---

# Request Flow

```
Browser

↓

ProductController

↓

ProductService

↓

WebClient

↓

HTTP GET

↓

User Service

↓

JSON Response

↓

bodyToMono(User.class)

↓

User DTO

↓

ProductController

↓

Browser
```

---

# Running the Project

## Start User Service

Runs on

```
http://localhost:8081
```

Test

```
GET /users/1
```

---

## Start Product Service

Runs on

```
http://localhost:8082
```

Test

```
GET /products/user/1
```

---

# WebClient Configuration

```java
@Bean
public WebClient webClient() {

    return WebClient.builder()
            .baseUrl("http://localhost:8081")
            .build();

}
```

---

# Product Service

```java
public User getUser(Long id){

    return webClient
            .get()
            .uri("/users/{id}",id)
            .retrieve()
            .bodyToMono(User.class)
            .block();

}
```

---

# Why WebClient?

- Modern replacement for RestTemplate
- Supports synchronous and asynchronous calls
- Non-blocking architecture
- Reactive programming support
- Better performance for high-concurrency applications
- Easy integration with Spring Boot

---

# Future Improvements

- Service Discovery (Eureka)
- Spring Cloud Gateway
- Resilience4j Circuit Breaker
- Retry Mechanism
- JWT Authentication
- Docker
- Kubernetes
- OpenTelemetry
- Distributed Tracing

---

# Learning Outcomes

After completing this project you will understand:

- Spring WebClient
- Microservices Communication
- REST API Consumption
- DTO Mapping
- Layered Architecture
- External Configuration
- Spring Boot Best Practices

---

# Author

**Aditya Pandey**
