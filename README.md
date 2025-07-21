# Event Management Platform

This is a **Spring Boot + Java + Kotlin** based backend service for managing events, ticket bookings, QR generation, and validation. It uses **PostgreSQL** as the database and **Keycloak** for authentication & role-based authorization.

---

## Features

- **Role-based access**: Organizer, Attendee, Staff
- **Event management**
- **Ticket booking and retrieval**
- **QR code generation for tickets**
- **Ticket validation via QR**

---

## Tech Stack

- **Java 21 & Kotlin 1.9.25**
- **Spring Boot**
  - Spring Web
  - Spring Security
  - Spring Data JPA
- **PostgreSQL + Adminer** (via Docker)
- **Keycloak as OAuth2 (via Docker)**
- **ZXing** (for QR code generation/validation)
- **MapStruct + Lombok**
- **Maven** as build tool

---

## Setup Guide

### 1. Clone Repository

```bash
git clone https://github.com/ZRishu/event-management-backend.git
cd event-management-backend
```

### 2. Environment Setup

- Copy `.env.example` to `.env` and fill in the values
- Or set them as environment variables manually

### 3. Start Dependencies (PostgreSQL & Keycloak)

```bash
docker compose up
```

- After Keycloak is running, create test users with roles:
  - `ROLE_ORGANIZER`
  - `ROLE_ATTENDEE`
  - `ROLE_STAFF`

### 4. Run Spring Boot App

```bash
./mvnw spring-boot:run
```

---

# API Endpoints

## Attendee Endpoints (`ROLE_ATTENDEE`)

| Method | Endpoint                                                       | Description                       |
|--------|----------------------------------------------------------------|-----------------------------------|
| GET    | `/api/v1/tickets`                                              | List logged-in attendee’s tickets |
| GET    | `/api/v1/tickets/{ticketId}`                                   | Get specific ticket details       |
| GET    | `/api/v1/tickets/{ticketId}/qr-codes`                          | Generate QR code for ticket       |
| POST   | `/api/v1/events/{eventId}/ticket-types/{ticketTypeId}/tickets` | Book ticket for an event          |

---

## Organizer Endpoints (`ROLE_ORGANIZER`)

| Method | Endpoint                   | Description                          |
|--------|----------------------------|--------------------------------------|
| GET    | `/api/v1/events`           | List events created by the organizer |
| POST   | `/api/v1/events`           | Create a new event                   |
| GET    | `/api/v1/events/{eventId}` | Get specific event details           |
| PUT    | `/api/v1/events/{eventId}` | Update event details                 |
| DELETE | `/api/v1/events/{eventId}` | Delete an event                      |

---

## Staff Endpoints (`ROLE_STAFF`)

| Method | Endpoint                     | Description                               |
|--------|------------------------------|-------------------------------------------|
| POST   | `/api/v1/ticket-validations` | Validate ticket Manually or using QR code |

---

## Public Endpoints (No Authentication Required)

| Method | Endpoint                             | Description                 |
|--------|--------------------------------------|-----------------------------|
| GET    | `/api/v1/published-events`           | List all published events   |
| GET    | `/api/v1/published-events/{eventId}` | Get a published event by ID |

---

## License

This project is licensed under the **[MIT License](LICENSE.txt)**.

