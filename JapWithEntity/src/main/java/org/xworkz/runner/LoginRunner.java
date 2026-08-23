package org.xworkz.runner;

import jakarta.persistence.*;
import org.xworkz.entity.LoginEntity;

public class LoginRunner {
    public static void main(String[] args) {

        LoginEntity loginEntity = new LoginEntity();
//        loginEntity.setLoginId(1122);
        loginEntity.setEmail("akasha@gmail.com");
        loginEntity.setPassword("Akaza@123");

        LoginEntity loginEntity1 = new LoginEntity();
        loginEntity1.setEmail("chinmay@123");
        loginEntity1.setPassword("chinmay@123");

        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;

        try {
            emf = Persistence.createEntityManagerFactory("akasha");
            em = emf.createEntityManager();
            et = em.getTransaction();

            et.begin();

            em.persist(loginEntity);
            em.persist(loginEntity1);

            et.commit();

        }catch (PersistenceException e){

            et.rollback();
            e.getMessage();

        }finally {
            if(emf != null){
                emf.close();
            }

            if (em != null){
                em.close();
            }
        }

    }
}
