import javax.persistence.*;
import javax.ws.rs.Path;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Collection;

import DAL.UserDB;
import bo.User;
import models.*;

/**
 * Created by Gurris on 2016-11-30.
 */
@Path("/hello")
public class ServletService {

    @Path("/world")
    @GET
    public String getHelloWorld(){
        return "HELLO WORLD";
    }
    @Path("/get/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public User findById(@PathParam("id")int id){

        UserEntity u = UserDB.findById(id);

        User usr = new User();
        usr.setId(u.getId());
        usr.setUsername(u.getUsername());
        usr.setFirstname(u.getFirstname());
        usr.setLastname(u.getLastname());
        usr.setPassword(u.getPassword());

        return usr;

    }

}
