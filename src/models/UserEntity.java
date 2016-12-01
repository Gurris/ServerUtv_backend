package models;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Gurris on 2016-11-30.
 */
@Entity
@Table(name = "user", schema = "serverutv")
@NamedQueries({
        @NamedQuery(name="UserEntity.findAll",
                query="SELECT u FROM UserEntity u"),

        @NamedQuery(name="UserEntity.findUserByName",
                query="SELECT u FROM UserEntity u WHERE u.username=:name")
})
public class UserEntity {
    private int id;
    private String username;
    private String email;
    private String password;
    private String firstname;
    private String lastname;
    private Collection<LogEntity> logsById;
    private Collection<LogEntity> logsById_0;
    private Collection<MessagesEntity> messagesById;
    private Collection<MessagesEntity> messagesById_0;

    @Id
    @Column(name = "Id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "Email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "Password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "Firstname")
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Basic
    @Column(name = "Lastname")
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        if (id != that.id) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
        if (lastname != null ? !lastname.equals(that.lastname) : that.lastname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "userByFromUser")
    public Collection<LogEntity> getLogsById() {
        return logsById;
    }

    public void setLogsById(Collection<LogEntity> logsById) {
        this.logsById = logsById;
    }

    @OneToMany(mappedBy = "userByToUser")
    public Collection<LogEntity> getLogsById_0() {
        return logsById_0;
    }

    public void setLogsById_0(Collection<LogEntity> logsById_0) {
        this.logsById_0 = logsById_0;
    }

    @OneToMany(mappedBy = "userByToUser")
    public Collection<MessagesEntity> getMessagesById() {
        return messagesById;
    }

    public void setMessagesById(Collection<MessagesEntity> messagesById) {
        this.messagesById = messagesById;
    }

    @OneToMany(mappedBy = "userByFromUser")
    public Collection<MessagesEntity> getMessagesById_0() {
        return messagesById_0;
    }

    public void setMessagesById_0(Collection<MessagesEntity> messagesById_0) {
        this.messagesById_0 = messagesById_0;
    }
}
