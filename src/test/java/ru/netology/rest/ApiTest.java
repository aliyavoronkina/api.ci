package ru.netology.rest;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

class ApiTest extends BaseTest {

    @Test
    void shouldReturnValidAccounts() {
        given()
                .baseUri("http://localhost:9999")
                .when()
                .get("/api/v1/demo/accounts")
                .then()
                .statusCode(200)
                .body("", hasSize(2))
                .body("[0].id", equalTo(1))
                .body("[0].name", equalTo("Account1"))
                .body("[1].id", equalTo(2))
                .body("[1].name", equalTo("Account2"));
    }
}