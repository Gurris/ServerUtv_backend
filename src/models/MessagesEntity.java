package models;

import javax.persistence.*;

/**
 * Created by Gurris on 2016-11-30.
 */
@Entity
@Table(name = "messages", schema = "serverutv", catalog = "")
public class MessagesEntity {
    private int id;
    private int toUser;
    private Integer fromUser;
    private String message;
    private UserEntity userByToUser;
    private UserEntity userByFromUser;

    @Id
    @Column(name = "Id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "toUser", insertable = false, updatable = false)
    public int getToUser() {
        return toUser;
    }

    public void setToUser(int toUser) {
        this.toUser = toUser;
    }

    @Basic
    @Column(name = "fromUser", insertable = false, updatable = false)
    public Integer getFromUser() {
        return fromUser;
    }

    public void setFromUser(Integer fromUser) {
        this.fromUser = fromUser;
    }

    @Basic
    @Column(name = "Message")
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MessagesEntity that = (MessagesEntity) o;

        if (id != that.id) return false;
        if (toUser != that.toUser) return false;
        if (fromUser != null ? !fromUser.equals(that.fromUser) : that.fromUser != null) return false;
        if (message != null ? !message.equals(that.message) : that.message != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + toUser;
        result = 31 * result + (fromUser != null ? fromUser.hashCode() : 0);
        result = 31 * result + (message != null ? message.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "toUser", referencedColumnName = "Id", nullable = false)
    public UserEntity getUserByToUser() {
        return userByToUser;
    }

    public void setUserByToUser(UserEntity userByToUser) {
        this.userByToUser = userByToUser;
    }

    @ManyToOne
    @JoinColumn(name = "fromUser", referencedColumnName = "Id")
    public UserEntity getUserByFromUser() {
        return userByFromUser;
    }

    public void setUserByFromUser(UserEntity userByFromUser) {
        this.userByFromUser = userByFromUser;
    }
}
