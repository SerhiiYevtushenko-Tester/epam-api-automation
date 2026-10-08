package com.epam.rd.autotasks.tests;

import com.epam.rd.autotasks.services.UserService;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class UserApiTest {

    private UserService userService;

    @BeforeClass
    public void setup() {
        userService = new UserService();
    }

    @Test
    public void testUsersStatusCode() {
        Response response = userService.getUsers();

        assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void testUsersContentTypeHeader() {
        Response response = userService.getUsers();

        assertNotNull(response.getHeader("Content-Type"));
        assertEquals(
                response.getHeader("Content-Type"),
                "application/json; charset=utf-8"
        );
    }

    @Test
    public void testUsersResponseBodyArraySize() {
        Response response = userService.getUsers();

        List<?> users = response.jsonPath().getList("$");

        assertNotNull(users);
        assertEquals(users.size(), 10);
    }

    @Test
    public void testCreateUser() {
        String requestBody = """
            {
                "name": "Test User",
                "username": "testuser",
                "email": "testuser@example.com"
            }
            """;

        Response response = userService.createUser(requestBody);

        assertEquals(response.getStatusCode(), 201);
        assertEquals(response.jsonPath().getString("name"), "Test User");
        assertEquals(response.jsonPath().getString("username"), "testuser");
        assertEquals(response.jsonPath().getString("email"), "testuser@example.com");
    }

    @Test
    public void testUpdateUser() {
        String requestBody = """
            {
                "name": "Updated User",
                "username": "updateduser",
                "email": "updateduser@example.com"
            }
            """;

        Response response = userService.updateUser(1, requestBody);

        assertEquals(response.getStatusCode(), 200);
        assertEquals(response.jsonPath().getString("name"), "Updated User");
        assertEquals(response.jsonPath().getString("username"), "updateduser");
        assertEquals(response.jsonPath().getString("email"), "updateduser@example.com");
    }

    @Test
    public void testDeleteUser() {
        Response response = userService.deleteUser(1);

        assertEquals(response.getStatusCode(), 200);
    }
}
