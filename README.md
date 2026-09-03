# Quiz App – Microservices

A backend **Quiz Application built with Java, Spring Boot, and Spring Cloud**, designed using a microservices architecture. The system separates quiz and question management into independent services and uses service discovery and API routing for communication.

## Overview

The application consists of four services:

- **API Gateway** – Central entry point that routes client requests.
- **Quiz Service** – Handles quiz creation, retrieval, and submission.
- **Question Service** – Manages questions, question generation, and answer evaluation.
- **Service Registry** – Uses Eureka for service registration and discovery.

## Architecture

```text
                         Client
                           │
                           ▼
                    ┌──────────────┐
                    │ API Gateway  │
                    └──────┬───────┘
                           │
                           ▼
                    ┌──────────────┐
                    │ Quiz Service │
                    └──────┬───────┘
                           │
                      OpenFeign
                           │
                           ▼
                  ┌──────────────────┐
                  │ Question Service │
                  └────────┬─────────┘
                           │
                           ▼
                      PostgreSQL

             ┌──────────────────────────┐
             │   Eureka Service Registry│
             │    Service Discovery     │
             └──────────────────────────┘
```
## Working Flow

1. The client sends a request through the **API Gateway**.
2. The Gateway routes the request to the **Quiz Service**.
3. The Quiz Service communicates with the **Question Service using OpenFeign** when questions are required.
4. The Question Service retrieves questions from PostgreSQL.
5. The quiz is generated and returned to the client.
6. When answers are submitted, the Question Service evaluates them and returns the score.
7. **Eureka** enables the services to discover each other without relying on fixed service locations.

## Key Features

- Microservices-based backend architecture
- RESTful API development
- Centralized request routing using API Gateway
- Service discovery using Netflix Eureka
- Inter-service communication using OpenFeign
- Quiz creation and management
- Question generation and management
- Answer evaluation and scoring
- PostgreSQL database integration

## Tech Stack

- **Language:** Java
- **Framework:** Spring Boot, Spring Cloud
- **Microservices:** Spring Cloud Gateway, Eureka, OpenFeign
- **Database:** PostgreSQL, Spring Data JPA
- **Build Tool:** Maven
- **Testing:** Postman
- **Version Control:** Git, GitHub
## Running the Project

Start the services in the following order:

1. Service Registry
2. Question Service
3. Quiz Service
4. API Gateway

Configure the required PostgreSQL database settings in the respective application.properties files before starting the services.             
             
