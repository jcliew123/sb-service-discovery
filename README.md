# Spring Boot with Eureka Service Discovery

This project demonstrates the use of Spring Boot in conjunction with Netflix Eureka for service discovery in a microservices architecture.

The system comprises the following components:

- **Service Discovery Server (`sb-service-discovery`)**: Acts as the Eureka server, managing service registration and discovery.
- **User Service (`user-service`)**: A microservice responsible for user-related operations(mock).
- **Order Service (`order-service`)**: A microservice responsible for order-related operations(mock).

## Stacks
- JDK 17
- Spring Boot Version 3.4.4


## Setup
1. **Setup Eureka Server**:
- Create a new Spring Boot project with the following dependencies:
  - **Spring Boot Web**
  - **Eureka Server**
 
- Add `@EnableEurekaServer` in the main application class:
- Configure application.yml:
  ```
  server:
    port: 8761  # Eureka server default port
  eureka:
    instance:
      hostname: localhost
    client:
      register-with-eureka: false
      fetch-registry: false
  ```
- Start the Eureka server:
  ```
  mvn spring-boot:run
  ```
- Dashboard available at: http://localhost:8761

2.**Register Microservices (Eureka Clients)**
- Add the `spring-cloud-starter-netflix-eureka-client` for each microservice
- EurekaClient would be auto-enabled when the dependency above is scanned
- Configure application.yml:
  ```
  server:
    port: port-number  # Change per service
  spring:
    application:
      name: service-name  # Unique name per service
  eureka:
    client:
      service-url:
        defaultZone: http://localhost:8761/eureka/ # Service Discovery 
  ```
- Start the service:
  ```
  mvn spring-boot:run
  ```
- Verify registration in http://localhost:8761

3.**Inter-Service Communication**
- Use **Spring Cloud OpenFeign** to allow services to communicate via service-discovery
- Add `spring-cloud-starter-openfeign` dependency
- Add `@EnableFeignClients` in main class
- Create Feign interface

## Dockering
1. Create Dockerfile for each service
2. Build images
3. Use Docker Compose to start:
   ```
   version: '1'
    services:
      eureka-server:
        image: eureka-server
        ports:
          - "8761:8761"
    
    user-service:
      image: user-service
      depends_on:
        - eureka-server
    ```

## Common Issue
- Service not registering?
  - Ensure Eureka server is running and defaultZone is set correctly
- Feign client failing?
  - Make sure the service name in `@FeignClient(name = "service-name")` matches the registered name

## TODO
1. Configure FeignClient to include Error Handling, Timeout, Retry, Fallback and CircuitBreaker