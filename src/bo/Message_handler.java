package bo;

import DAL.MessageDB;
import models.MessagesEntity;
import models.UserEntity;

import java.util.ArrayList;

/**
 * Created by Gustaf on 2016-11-25.
 */
public class Message_handler {

    public static void sendMessageToId(Message msg){
        MessagesEntity dbMsg = new MessagesEntity();
        dbMsg.setId(msg.getId());
        UserEntity usr1 = new UserEntity();
        usr1.setId(msg.getFromUser().getId());
        usr1.setUsername(msg.getFromUser().getUsername());
        usr1.setFirstname(msg.getFromUser().getFirstname());
        usr1.setLastname(msg.getFromUser().getLastname());
        usr1.setEmail(msg.getFromUser().getEmail());
        dbMsg.setUserByFromUser(usr1);

        UserEntity usr2 = new UserEntity();
        usr2.setId(msg.getToUser().getId());
        usr2.setUsername(msg.getToUser().getUsername());
        usr2.setFirstname(msg.getToUser().getFirstname());
        usr2.setLastname(msg.getToUser().getLastname());
        usr2.setEmail(msg.getToUser().getEmail());
        dbMsg.setUserByToUser(usr2);

        dbMsg.setMessage(msg.getMessage());

        MessageDB.sendMessageToUser(dbMsg);
    }

    public static ArrayList<Message> getMessagesForUser(String username){
        User usrFromId = User_handler.findUserByName(username);

        if(usrFromId != null){

            ArrayList<MessagesEntity> messages = MessageDB.getMessagesForUser(usrFromId.getId());
            ArrayList<Message> convertedMessages = new ArrayList<>();

            for(int i=0; i<messages.size(); i++){
                Message msg = new Message();
                msg.setId(messages.get(i).getId());

                User from = new User();
                from.setId(messages.get(i).getId());
                from.setUsername(messages.get(i).getUserByFromUser().getUsername());
                msg.setFromUser(from);

                User to = new User();
                to.setId(messages.get(i).getId());
                to.setUsername(messages.get(i).getUserByToUser().getUsername());
                msg.setToUser(to);
                msg.setMessage(messages.get(i).getMessage());
                convertedMessages.add(msg);
            }
            return convertedMessages;
        }

        return null;
    }

}
