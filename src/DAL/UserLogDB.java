package DAL;

import models.LogEntity;
import models.UserEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;

/**
 * Created by Gurris on 2016-11-12.
 */
public class UserLogDB {

    public static boolean addToUserLog(UserEntity toUser, UserEntity fromUser, String log_message){
        try{
            System.out.println("awdagsrg");
            System.out.println("toUser: " + toUser.getUsername() + " fromUser: " + fromUser.getUsername());
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("NewPersistenceUnit");
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();

            LogEntity log = new LogEntity();
            log.setLogMessage(log_message);
            log.setUserByFromUser(fromUser);
            log.setUserByToUser(toUser);
            em.persist(log);
            em.flush();
            em.getTransaction().commit();
            System.out.println("log id is: " + log.getId());
            return true;
        }catch (Exception e){
            System.out.println("------UserLogDB / addToUserLog---------");
            e.printStackTrace();
            System.out.println("----------------------------------");
            return false;
        }

    }

    public static ArrayList<LogEntity> getUsersLogFromUId(int id){
        try{
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("NewPersistenceUnit");
            EntityManager em = emf.createEntityManager();

            Query q = em.createQuery("select log from LogEntity log where log.toUser in (:id)");
            q.setParameter("id", id);

            ArrayList<LogEntity> users = (ArrayList<LogEntity>) q.getResultList();
            return users;
        }catch (Exception e){
            System.out.println("------UserLogDB / getUsersLogFromUId---------");
            e.printStackTrace();
            System.out.println("----------------------------------");
            return null;
        }
    }

}
