package de.fhdw.jacobs.services;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MessageService {

    @ConfigProperty(name = "quarkus.application.name")
    String applicationName;

    public String process(String message) {
        return "You send the service " + applicationName
                + " the following message: " + message;
    }

}
