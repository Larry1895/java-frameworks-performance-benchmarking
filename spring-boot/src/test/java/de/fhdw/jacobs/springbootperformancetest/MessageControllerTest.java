package de.fhdw.jacobs.springbootperformancetest;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MessageControllerTest {

    private static final int EXPECTED_STATUS = 200;
    private static final String EXPECTED_MESSAGE = "You send the service performanceTest the following message: Hello";

    @LocalServerPort
    int port;

    @BeforeEach
    void setup() {
        RestAssured.port = port;
    }

    @Test
    void testMessage() {
        given()
                .when().get("/message/Hello")
                .then()
                .statusCode(EXPECTED_STATUS)
                .body(is(EXPECTED_MESSAGE));
    }
}