package restful;

import bo.Log;
import bo.Log_handler;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import bo.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import bo.User;
import bo.User_handler;
/**
 * Created by Gurris on 2016-12-01.
 */


@Path("/message")
public class message {

    @Path("/sendMessageToId")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void sendMessageToId(Message msg){
        Message_handler.sendMessageToId(msg);
    }

    @Path("/getMessagesForUser/{username}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Message> getMessagesForUser(@PathParam("username")String username){
        ArrayList<Message> messages = Message_handler.getMessagesForUser(username);
        return messages;
    }



}
