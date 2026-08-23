package org.xworkz.runner;

import jakarta.persistence.*;
import org.xworkz.entity.ShoesEntity;

public class ShoesRunner {
    public static void main(String[] args) {

        ShoesEntity shoesEntity = new ShoesEntity();
        shoesEntity.setShoesName("Harish");
        shoesEntity.setShoesType("Runing");

        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;

        try{
            emf = Persistence.createEntityManagerFactory("akasha");
            em = emf.createEntityManager();
            et = em.getTransaction();

            et.begin();

            em.persist(shoesEntity);

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
