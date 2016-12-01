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



/**
 * Created by Gurris on 2016-12-01.
 */
@Path("/message")
public class message {
/*
    @Path("/getUserLogFromUId/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Log> getUserLogFromUId(@PathParam("id")int id){
        ArrayList<Log> log = Log_handler.getUserLogFromUId(id);
        return log;
    }
*/
    @Path("/getUserLogFromUId/{message}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public void sendMessageToId(){

    }



}
