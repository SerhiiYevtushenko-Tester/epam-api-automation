# API Automation

API automation tests for the JSONPlaceholder `/users` REST resource.

## Technologies

- Java 21
- Maven
- TestNG
- REST Assured

## Covered API

Base resource:

`https://jsonplaceholder.typicode.com/users`

The project covers the following API operations:

- **GET** — verify status code, response header, and response body
- **POST** — create a user
- **PUT** — update a user
- **DELETE** — delete a user

## Test Coverage

### GET

- Verify HTTP status code is `200 OK`
- Verify `Content-Type` header exists
- Verify `Content-Type` is `application/json; charset=utf-8`
- Verify the response body contains an array of 10 users

### CRUD

- Create a user using `POST`
- Update a user using `PUT`
- Delete a user using `DELETE`

## Parallel Execution

Tests are configured to run in parallel using TestNG.

## How to Run

Run all tests with Maven:

```bash
mvn clean test
