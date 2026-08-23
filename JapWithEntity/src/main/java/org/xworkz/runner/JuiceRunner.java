package org.xworkz.runner;

import jakarta.persistence.*;
import org.xworkz.entity.JuiceEntity;

public class JuiceRunner {
    public static void main(String[] args) {

        JuiceEntity juiceEntity = new JuiceEntity();
        juiceEntity.setJuiceName("Pineapple");
        juiceEntity.setJuiceType("Large");

        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;

        try{
            emf = Persistence.createEntityManagerFactory("akasha");
            em = emf.createEntityManager();
            et = em.getTransaction();

            et.begin();
            em.persist(juiceEntity);
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
