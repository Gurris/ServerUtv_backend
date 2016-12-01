package restful;

import bo.*;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
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

    @Path("/getFromUsername/{username}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public User findUserByName(@PathParam("username")String username){
        User usr = User_handler.findUserByName(username);
        return usr;

    }


}
