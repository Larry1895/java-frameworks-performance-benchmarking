package de.fhdw.jacobs.controller;

import de.fhdw.jacobs.services.MessageService;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

import javax.validation.constraints.NotBlank;

@Controller("/message")
public class MessageController {


    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @Get(value = "/{message}", produces = MediaType.TEXT_PLAIN)
    public String getMessage(@NotBlank String message) {
        return messageService.process(message);
    }
}
