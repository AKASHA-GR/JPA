package org.xworkz.runner;

import jakarta.persistence.*;
import org.xworkz.entity.LoginEntity;

import java.text.ParseException;

public class LoginReadRunner {
    public static void main(String[] args) {

        EntityManagerFactory emf = null;
        EntityManager em = null;EntityTransaction et = null;

        try{
            emf = Persistence.createEntityManagerFactory("akasha");
            em = emf.createEntityManager();

            LoginEntity loginEntity = em.find(LoginEntity.class,1);
            System.out.println("The Login detaies:"+loginEntity);



        }catch (PersistenceException e){
            e.getMessage();
        }finally {
            if(emf != null){
                emf.close();
            }

            if(em != null){
                em.close();
            }
        }

    }
}
