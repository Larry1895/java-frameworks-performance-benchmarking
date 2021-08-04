package de.fhdw.jacobs.services;

import io.micronaut.context.annotation.Value;

public class MessageService {

    @Value("${micronaut.application.name}")
    public String applicationName;

    public String process(String message) {
        return "You send the service " + applicationName
                + " the following message: " + message;
    }
}
