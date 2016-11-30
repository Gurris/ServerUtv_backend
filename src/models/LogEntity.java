package models;

import javax.persistence.*;

/**
 * Created by Gurris on 2016-11-30.
 */
@Entity
@Table(name = "log", schema = "serverutv", catalog = "")
public class LogEntity {
    private int id;
    private int fromUser;
    private int toUser;
    private String logMessage;
    private UserEntity userByFromUser;
    private UserEntity userByToUser;

    @Id
    @Column(name = "Id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "fromUser", insertable = false, updatable = false)
    public int getFromUser() {
        return fromUser;
    }

    public void setFromUser(int fromUser) {
        this.fromUser = fromUser;
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
    @Column(name = "Log_message")
    public String getLogMessage() {
        return logMessage;
    }

    public void setLogMessage(String logMessage) {
        this.logMessage = logMessage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LogEntity logEntity = (LogEntity) o;

        if (id != logEntity.id) return false;
        if (fromUser != logEntity.fromUser) return false;
        if (toUser != logEntity.toUser) return false;
        if (logMessage != null ? !logMessage.equals(logEntity.logMessage) : logEntity.logMessage != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + fromUser;
        result = 31 * result + toUser;
        result = 31 * result + (logMessage != null ? logMessage.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "fromUser", referencedColumnName = "Id", nullable = false)
    public UserEntity getUserByFromUser() {
        return userByFromUser;
    }

    public void setUserByFromUser(UserEntity userByFromUser) {
        this.userByFromUser = userByFromUser;
    }

    @ManyToOne
    @JoinColumn(name = "toUser", referencedColumnName = "Id", nullable = false)
    public UserEntity getUserByToUser() {
        return userByToUser;
    }

    public void setUserByToUser(UserEntity userByToUser) {
        this.userByToUser = userByToUser;
    }
}
