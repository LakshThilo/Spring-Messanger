package com.lak.messanger.resorces;

import com.lak.messanger.model.Message;
import com.lak.messanger.services.MessageService;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/messages")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MessageResources {

    MessageService ms = new MessageService();

    @GET
    public List<Message> getMessages(@QueryParam("year") int year,
                                     @QueryParam("start") int start,
                                     @QueryParam("size") int size) {
        if (year > 0) {
        return ms.getAllMessagesFroYear(year);
        // try this URL in POSTMAN ----  http://localhost:8080/Messanger/rest/messages?year=2020
        }
        if (start >= 0 && size >= 0) {
            return ms.getAllMessagesPaginated(start, size);
        }
        return ms.getAllMessages();
    }

    @GET
    @Path("/{messageId}")
    public Message getMessages(@PathParam("messageId") long id){

        return ms.getMessage(id);
    }

    @POST
    public Message getMessage(Message message){

        return ms.addMessage(message);
    }

    @PUT
    @Path("/{messageId}")
    public Message updateMessages(@PathParam("messageId") long id, Message message){
        message.setId(id);
        return ms.updateMessage(message);
    }

    @DELETE
    @Path("/{messageId}")
    public Message deleteMessages(@PathParam("messageId") long id){
        return ms.removeMessage(id);
    }

}