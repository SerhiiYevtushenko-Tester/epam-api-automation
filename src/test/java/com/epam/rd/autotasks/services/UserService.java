package com.epam.rd.autotasks.services;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserService {

    private final String endpoint = "https://jsonplaceholder.typicode.com/users";

    public Response getUsers() {
        return given()
                .log().all()
                .when()
                .get(endpoint)
                .then().log().all()
                .extract().response();
    }

    public Response createUser(String requestBody) {
        return given()
                .log().all()
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post(endpoint)
                .then().log().all()
                .extract().response();
    }

    public Response updateUser(int id, String requestBody) {
        return given()
                .log().all()
                .contentType("application/json")
                .body(requestBody)
                .when()
                .put(endpoint + "/" + id)
                .then().log().all()
                .extract().response();
    }

    public Response deleteUser(int id) {
        return given()
                .log().all()
                .when()
                .delete(endpoint + "/" + id)
                .then().log().all()
                .extract().response();
    }
}
