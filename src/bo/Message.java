package bo;

/**
 * Created by Gustaf on 2016-11-25.
 */
public class Message {
    private int Id;
    private User toUser;
    private User fromUser;
    private String message;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public User getToUser() {
        return toUser;
    }

    public void setToUser(User toUser) {
        this.toUser = toUser;
    }

    public User getFromUser() {
        return fromUser;
    }

    public void setFromUser(User fromUser) {
        this.fromUser = fromUser;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
