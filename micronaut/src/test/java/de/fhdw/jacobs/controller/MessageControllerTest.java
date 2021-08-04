package de.fhdw.jacobs.controller;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

@MicronautTest
class MessageControllerTest {

    private static final HttpStatus EXPECTED_STATUS = HttpStatus.OK;
    private static final String EXPECTED_MESSAGE = "You send the service performanceTest the following message: Hello";

    @Inject
    @Client("/")
    RxHttpClient client;

    @Test
    void testMessage() {
        HttpResponse<String> actual = client.toBlocking().exchange(
                "/message/Hello", String.class
        );

        Assertions.assertEquals(
                EXPECTED_STATUS,
                actual.status()
        );

        Assertions.assertEquals(
                EXPECTED_MESSAGE,
                actual.body()
        );
    }
}