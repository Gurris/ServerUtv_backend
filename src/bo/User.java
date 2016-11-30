package bo;

import java.util.ArrayList;

/**
 * Created by Gurris on 2016-11-03.
 */
public class User {
    private String username;
    private int id;
    private String Firstname;
    private String Lastname;
    private String email;
    private String password;
    private ArrayList<Log> log;


    public User(String name, String Firstname, String Lastname, int id) {
        this.username = name;
        this.Firstname = Firstname;
        this.Lastname = Lastname;
        this.id = id;
    }
    public User(){

    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return Firstname;
    }

    public void setFirstname(String firstname) {
        Firstname = firstname;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String lastname) {
        Lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public ArrayList<Log> getLog() {
        return log;
    }

    public void setLog(ArrayList<Log> log) {
        this.log = log;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
