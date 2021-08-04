package de.fhdw.jacobs.springbootperformancetest.services;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    @Value("${spring.application.name}")
    private String applicationName;

    public String process(String message) {
        return "You send the service " + applicationName
                + " the following message: " + message;
    }

}
