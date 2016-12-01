package restful;

import bo.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import bo.User;
import bo.User_handler;

/**
 * Created by Gurris on 2016-12-01.
 */
@Path("/log")
public class log {

    @Path("/getUserLogFromUId/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Log> getUserLogFromUId(@PathParam("id")int id){
        ArrayList<Log> log = Log_handler.getUserLogFromUId(id);
        return log;
    }

    @Path("/addToUserLog/{toUser}/{fromUser}/{log_message}")
    @GET
    public void addToUserLog(@PathParam("toUser")int toUser, @PathParam("fromUser")int fromUser, @PathParam("log_message")String log_message ){
        Log_handler.addToUserLog(toUser, fromUser, log_message);
    }


}
