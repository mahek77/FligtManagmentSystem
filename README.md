# Flight Management System

A simple Flight Booking Management System built with Spring Boot, PostgreSQL, HTML, CSS, and JavaScript.

This project allows an admin to manage flights and allows users to view available flights, create bookings, and make payments.

---

## Features

### Admin Features

- Admin login
- Add new flights
- Update existing flights
- Delete flights
- View all flights
- View all bookings
- Track available seats after booking

### User Features

- User signup
- User login
- View all available flights
- Select a flight
- Create booking
- Enter passenger details
- Make payment
- Seats are automatically reduced after successful booking

---

## Technologies Used

### Backend

- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- PostgreSQL
- Gradle

### Frontend

- HTML
- CSS
- JavaScript

### Deployment

- GitHub
- Render
- Neon PostgreSQL Database
- Docker

---

## Project Structure

```text
FlightManagementSystem
│
├── src
│   └── main
│       ├── java
│       │   └── com.example.myflightdb
│       │       ├── Controllers
│       │       ├── Entities
│       │       ├── Repositories
│       │       └── services
│       │
│       └── resources
│           ├── static
│           │   ├── login.html
│           │   ├── signup.html
│           │   ├── admin.html
│           │   ├── user.html
│           │   ├── booking.html
│           │   ├── payment.html
│           │   ├── login.css
│           │   ├── admin.css
│           │   ├── user.css
│           │   ├── booking.css
│           │   ├── payment.css
│           │   ├── login.js
│           │   ├── signup.js
│           │   ├── admin.js
│           │   ├── user.js
│           │   ├── booking.js
│           │   ├── payment.js
│           │   └── img.png
│           │
│           └── application.properties
│
├── build.gradle
├── settings.gradle
├── Dockerfile
└── README.md
