package com.epam.rd.autotasks.services;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserService {

    private final String endpoint = "https://jsonplaceholder.typicode.com/users";

    public Response getUsers() {
        return given()
                .when()
                .get(endpoint);
    }
}
