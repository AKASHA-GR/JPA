package org.xworkz.runner;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceException;
import org.xworkz.entity.ShoesEntity;

public class ShoesReadRunner {
    public static void main(String[] args) {

        EntityManagerFactory emf = null;
        EntityManager em = null;

        try{
            emf = Persistence.createEntityManagerFactory("akasha");
            em = emf.createEntityManager();

            ShoesEntity shoesEntity =em.find(ShoesEntity.class,1);
            System.out.println("Retrieved data:"+shoesEntity);
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
