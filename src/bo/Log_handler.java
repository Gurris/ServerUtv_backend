package bo;

import DAL.UserDB;
import DAL.UserLogDB;
import models.LogEntity;
import models.UserEntity;

import java.util.ArrayList;

/**
 * Created by Gurris on 2016-11-12.
 */
public class Log_handler {

    public static ArrayList<Log> getUserLogFromUId(int userId){

        ArrayList<LogEntity> queryResult = UserLogDB.getUsersLogFromUId(userId);
        ArrayList<Log> convertedResult = new ArrayList<>();

        for(int i=0; i<queryResult.size(); i++){
            Log msg = new Log();
            msg.setLog_message(queryResult.get(i).getLogMessage());
            msg.setToUser(queryResult.get(i).getUserByToUser().getUsername());
            msg.setFromUser(queryResult.get(i).getUserByFromUser().getUsername());
            msg.setId(queryResult.get(i).getId());
            convertedResult.add(msg);
        }
        return convertedResult;
    }

    public static void addToUserLog(int toUser, int fromUser, String log_message){
        UserEntity from = UserDB.findById(toUser);
        UserEntity to = UserDB.findById(fromUser);
        if(from == null || to == null)
            return;

        UserLogDB.addToUserLog(from, to, log_message);
    }

}
