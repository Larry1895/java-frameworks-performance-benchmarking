package de.fhdw.jacobs.resources;

import de.fhdw.jacobs.services.MessageService;


import javax.inject.Inject;
import javax.validation.constraints.NotBlank;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/message")
public class MessageResource {

    @Inject
    MessageService messageService;

    @GET
    @Path("/{message}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getMessage(@NotBlank @PathParam("message") String message) {
        return messageService.process(message);
    }
}
