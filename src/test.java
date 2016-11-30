import DAL.UserDB;
import models.UserEntity;

/**
 * Created by Gurris on 2016-11-30.
 */
public class test {
    public static void main(String[] args){
        UserEntity usr = UserDB.findById(1);
        System.out.println(usr.getUsername());
        System.out.println(usr.getFirstname());
    }

}
