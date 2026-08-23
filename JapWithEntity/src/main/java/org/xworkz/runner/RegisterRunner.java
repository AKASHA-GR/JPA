package org.xworkz.runner;

import jakarta.persistence.*;
import org.xworkz.entity.RegisterEntity;

public class RegisterRunner {
    public static void main(String[] args) {

        RegisterEntity registerEntity = new RegisterEntity();
        registerEntity.setName("CHETHAN");
        registerEntity.setEmail("chethan@gmail.com");

        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;

        try {
            emf = Persistence.createEntityManagerFactory("akasha");
            em = emf.createEntityManager();
            et = em.getTransaction();

            et.begin();

            em.persist(registerEntity);

            et.commit();
        }catch (PersistenceException e){
            et.rollback();
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
