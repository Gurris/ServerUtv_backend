package bo;

import DAL.UserDB;
import models.UserEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gurris on 2016-11-03.
 */
public class User_handler {

    public static boolean login(String username, String pass) {
        UserEntity user = UserDB.findByName(username);
        if(user == null)
            return false;
        if (user.getUsername().equalsIgnoreCase(username) && user.getPassword().equals(pass))
            return true;
        else
            return false;
    }

    public static User findUserByName(String username){ // one user
        System.out.println("handler");
        UserEntity queryResult = UserDB.findByName(username);
        User user = new User();

        user.setId(queryResult.getId());
        user.setUsername(queryResult.getUsername());
        user.setFirstname(queryResult.getFirstname());
        user.setLastname(queryResult.getLastname());
        user.setPassword(queryResult.getPassword());

        if(queryResult != null){
            ArrayList<Log> logs = Log_handler.getUserLogFromUId(user.getId());
            if(!logs.isEmpty())
                user.setLog(logs);

        }else{
            user.setLog(null);
        }
        return user;
    }

    public static List<User> getAllUsers(){
        System.out.println("GET ALL USERS");
        List<UserEntity> users = UserDB.getAll();
        List<User> newList = new ArrayList<>();
        for(int i=0; i<users.size(); i++){
            User tmp = new User();
            tmp.setId(users.get(i).getId());
            tmp.setFirstname(users.get(i).getFirstname());
            tmp.setLastname(users.get(i).getLastname());
            tmp.setUsername(users.get(i).getUsername());

            List<Log> uLog = Log_handler.getUserLogFromUId(users.get(i).getId());
            newList.add(tmp);
        }
        return newList;
    }

    public static List<User> findUsersByName(String username){ // all users with name like username
        List<UserEntity> users = UserDB.findUsersByUsername(username);
        List<User> newList = new ArrayList<>();
        for(int i=0; i<users.size(); i++){
            User tmp = new User();
            tmp.setId(users.get(i).getId());
            tmp.setFirstname(users.get(i).getFirstname());
            tmp.setLastname(users.get(i).getLastname());
            tmp.setUsername(users.get(i).getUsername());
            newList.add(tmp);
        }
        return newList;
    }

    public static User getUserById(int id){

        UserEntity dbUser = UserDB.findById(id);
        if(dbUser == null)
            return null;

        User user = new User();
        user.setFirstname(dbUser.getFirstname());
        user.setLastname(dbUser.getLastname());
        user.setUsername(dbUser.getUsername());
        user.setId(dbUser.getId());

        ArrayList<Log> log = Log_handler.getUserLogFromUId(id);
        if(log == null)
            return user;

        user.setLog(log);
        return user;
    }

    public static boolean registerUser(User user){
        if(user == null)
            return false;
        System.out.println("---------------------->");
        UserEntity userEntity = new UserEntity();
        userEntity.setFirstname(user.getFirstname());
        userEntity.setLastname(user.getLastname());
        userEntity.setUsername(user.getUsername());
        userEntity.setEmail(user.getEmail());
        userEntity.setPassword(user.getPassword());

        return UserDB.registerUser(userEntity);
    }

}
