package restful;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import bo.User;
import bo.User_handler;
import java.util.List;

/**
 * Created by Gurris on 2016-11-30.
 */
@Path("/user")
public class user {

    @Path("/getUserById/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public User findById(@PathParam("id")int id){
        User user = User_handler.getUserById(id);
        return user;
    }

    @Path("/getFromUsername/{username}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public User findUserByName(@PathParam("username")String username){
        User usr = User_handler.findUserByName(username);
        return usr;
    }

    @Path("/getAllUsers")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getAllUsers(){
        List<User> users = User_handler.getAllUsers();
        return users;
    }

    @Path("/registerUser")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean registerUser(User usr){
        System.out.println("REGISTARTION DATA!");
        boolean result = User_handler.registerUser(usr);
        System.out.println("result: " + result);
        return result;
    }


}
