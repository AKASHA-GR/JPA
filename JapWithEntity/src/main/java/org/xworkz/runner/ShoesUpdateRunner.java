package org.xworkz.runner;

import jakarta.persistence.*;
import org.xworkz.entity.ShoesEntity;

public class ShoesUpdateRunner {
    public static void main(String[] args) {

        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;

        try{
            emf = Persistence.createEntityManagerFactory("akasha");
            em = emf.createEntityManager();
            et = em.getTransaction();

            et.begin();

            ShoesEntity shoesEntity = em.find(ShoesEntity.class, 1);
            System.out.println("The Retrieved data:"+shoesEntity);

            shoesEntity.setShoesName("Bata");
            shoesEntity.setShoesType("Formal");

            ShoesEntity shoesEntity1 = em.find(ShoesEntity.class, 1);
            System.out.println("The Upadate data:"+shoesEntity1);


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
