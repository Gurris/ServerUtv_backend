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

    @Path("/addToUserLog")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addToUserLog(Log log){
        Log_handler.addToUserLog(log.getToUserId(), log.getFromUserId(), log.getLog_message());
    }

}
