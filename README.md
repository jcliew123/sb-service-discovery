# Spring Boot with Eureka Service Discovery

This project demonstrates the use of Spring Boot in conjunction with Netflix Eureka for service discovery in a microservices architecture.

The system comprises the following components:

- **Service Discovery Server (`sb-service-discovery`)**: Acts as the Eureka server, managing service registration and discovery.
- **User Service (`user-service`)**: A microservice responsible for user-related operations(mock).
- **Order Service (`order-service`)**: A microservice responsible for order-related operations(mock).

## Stacks
- JDK 17
- Spring Boot Version 3.4.4

1. **Setup Eureka Server**:
- Create a new Spring Boot project with the following dependencies:
  - **Spring Boot Web**
  - **Eureka Server**
 
- Add `@EnableEurekaServer` in the main application class:
- Configure application.yml:
  server:
    port: 8761  # Eureka server default port
  eureka:
    instance:
      hostname: localhost
    client:
      register-with-eureka: false
      fetch-registry: false
- Dashboard available at: http://localhost:8761
- Start the Eureka server:
  ```
  mvn spring-boot:run
  ```
2.**Register Microservices (Eureka Clients)**
- Add the `spring-cloud-starter-netflix-eureka-client` for each microservice
- EurekaClient would be auto-enabled when the dependency above is scanned
