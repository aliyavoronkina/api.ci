import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class ApiTest {

    @Test
    public void shouldReturnValidAccounts() {
        given()
                .baseUri("http://localhost:8080")  // URL вашего сервиса
                .contentType(ContentType.JSON)
                .when()
                .get("/api/accounts")  // endpoint для получения счетов
                .then()
                .statusCode(200)
                .body(matchesJsonSchemaInClasspath("accounts.schema.json"));
    }
}