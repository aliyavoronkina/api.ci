import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.oneOf;

class BankApiTest {

    @BeforeAll
    static void setUp() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 9999;
    }

    @Test
    void serverShouldBeRunning() {
        // Простой тест что сервер отвечает (любой статус кроме таймаута)
        given()
                .when()
                .get("/api/accounts")
                .then()
                .statusCode(oneOf(200, 404, 405));
    }
}