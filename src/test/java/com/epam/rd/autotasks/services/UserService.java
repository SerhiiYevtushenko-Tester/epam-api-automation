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

    public Response createUser(String requestBody) {
        return given()
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post(endpoint);
    }

    public Response updateUser(int id, String requestBody) {
        return given()
                .contentType("application/json")
                .body(requestBody)
                .when()
                .put(endpoint + "/" + id);
    }

    public Response deleteUser(int id) {
        return given()
                .when()
                .delete(endpoint + "/" + id);
    }
}
