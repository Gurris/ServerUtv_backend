package DAL;

import models.MessagesEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;

/**
 * Created by Gustaf on 2016-11-25.
 */
public class MessageDB {

    public static boolean sendMessageToUser(MessagesEntity msg){
        try{
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("NewPersistenceUnit");
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();

            em.persist(msg);
            em.flush();
            em.getTransaction().commit();
            System.out.println("Message id is: " + msg.getId());
            return true;

        }catch (Exception e){
            System.out.println("------MessagesDB / sendMessageToId---------");
            e.printStackTrace();
            System.out.println("----------------------------------");
            return false;
        }
    }

    public static ArrayList<MessagesEntity> getMessagesForUser(int id){
        try{
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("NewPersistenceUnit");
            EntityManager em = emf.createEntityManager();

            Query q = em.createQuery("select message from MessagesEntity message where message.userByToUser.id in (:id)");
            q.setParameter("id", id);

            ArrayList<MessagesEntity> messages = (ArrayList<MessagesEntity>) q.getResultList();
            return messages;
        }catch (Exception e){
            System.out.println("------UserLogDB / getMessageForUser---------");
            e.printStackTrace();
            System.out.println("----------------------------------");
            return null;
        }
    }

}
