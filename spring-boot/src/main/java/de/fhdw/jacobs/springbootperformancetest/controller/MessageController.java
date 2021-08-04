package de.fhdw.jacobs.springbootperformancetest.controller;

import de.fhdw.jacobs.springbootperformancetest.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;

@RestController
@RequestMapping("/message")
@Validated
public class MessageController {

    @Autowired
    private MessageService messageService;

    @GetMapping(value = "/{message}", produces = MediaType.TEXT_PLAIN_VALUE)
    public String getMessage(@NotBlank @PathVariable("message") String message) {
        return messageService.process(message);
    }
}
