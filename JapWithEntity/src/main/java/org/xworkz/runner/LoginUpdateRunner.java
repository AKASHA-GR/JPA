package org.xworkz.runner;

import jakarta.persistence.*;
import org.xworkz.entity.LoginEntity;

public class LoginUpdateRunner {
    public static void main(String[] args) {

        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;

        try{
            emf = Persistence.createEntityManagerFactory("akasha");
            em = emf.createEntityManager();
            et = em.getTransaction();

            et.begin();

            LoginEntity loginEntity = em.find(LoginEntity.class, 1);
            System.out.println("Retrival data:"+loginEntity);

            loginEntity.setEmail("priya@gmailcom");
            loginEntity.setPassword("HIII@124");

            LoginEntity loginEntity1 = em.merge(loginEntity);
            System.out.println("Udated Data:"+loginEntity1);

            et.commit();

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
