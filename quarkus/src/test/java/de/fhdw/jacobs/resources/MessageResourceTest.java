package de.fhdw.jacobs.resources;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class MessageResourceTest {

    private static final int EXPECTED_STATUS = 200;
    private static final String EXPECTED_MESSAGE = "You send the service performanceTest the following message: Hello";

    @Test
    public void testHelloEndpoint() {
        given()
                .when().get("/message/Hello")
                .then()
                .statusCode(EXPECTED_STATUS)
                .body(is(EXPECTED_MESSAGE));
    }

}