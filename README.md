# Spring Boot Date & Time API

## Overview
This project is a Spring Boot REST API demonstrating **proper handling of Java Date and Time APIs** using `java.time` classes along with JPA persistence.

It focuses on:
- Correct usage of modern date-time types
- JSON serialization/deserialization using `@JsonFormat`
- Storing date-time values in a relational database
- Clean layered architecture

---

## Tech Stack
- Java 25
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate
- MySQL
- Jackson

---

## Architecture
```

Client → Controller → Service → Repository → Database

````

- **Controller**: Handles HTTP requests
- **Service**: Business logic
- **Repository**: JPA persistence
- **Entity**: Date & time modeling

---

## Date & Time Types Used

| Type | Purpose |
|----|-------|
| `LocalDate` | Date only (no time, no timezone) |
| `LocalTime` | Time only |
| `LocalDateTime` | Date & time without timezone |
| `OffsetDateTime` | Date & time with UTC offset |
| `ZonedDateTime` | Date & time with timezone region |
| `Date` | Legacy mutable date type |

---

## JSON Formatting
All date-time fields use `@JsonFormat` to enforce consistent request and response formats.

Example:
```java
@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssXXX")
private OffsetDateTime offsetDateTime;
````

---

## API Endpoint

| Method | Endpoint         | Description               |
| ------ | ---------------- | ------------------------- |
| POST   | /datetime/create | Save date and time values |

---

## Sample Request (Postman)

```json
{
  "localDate": "2026-01-07",
  "localTime": "14:30:00",
  "localDateTime": "2026-01-07T14:30:00",
  "offsetDateTime": "2026-01-07T14:30:00+05:30",
  "zonedDateTime": "2026-01-07T14:30:00+05:30[Asia/Kolkata]",
  "date": "2026-01-07T14:30:00.000+05:30"
}
```

---

## How to Run

### Prerequisites

* Java 25
* Maven
* MySQL database

### Steps

1. Clone the repository

   ```bash
   git clone <repository-url>
   cd spring-boot-date-time-api
   ```

2. Configure database properties in `application.yml`

3. Build the project

   ```bash
   mvn clean install
   ```

4. Run the application

   ```bash
   mvn spring-boot:run
   ```

5. Application runs on:

   ```
   http://localhost:8080
   ```

---

## Application Entry Point

```java
@SpringBootApplication
public class DateAndTimeApplication {
    public static void main(String[] args) {
        SpringApplication.run(DateAndTimeApplication.class, args);
    }
}
```

---

## Key Takeaways

* Demonstrates correct use of `java.time` API
* Shows JSON formatting with `@JsonFormat`
* Avoids common date-time pitfalls
* Clean, production-style Spring Boot project

---

## Conclusion

This project serves as a reference implementation for handling date and time correctly in Spring Boot REST APIs using modern Java practices.
