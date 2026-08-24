package org.xworkz.runner;

import jakarta.persistence.*;
import org.xworkz.entity.RegisterEntity;

public class RegisterUpdateRunner {
    public static void main(String[] args) {

        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;

        try{
            emf = Persistence.createEntityManagerFactory("akasha");
            em = emf.createEntityManager();
            et = em.getTransaction();

            et.begin();

            RegisterEntity registerEntity = em.find(RegisterEntity.class,1);
            System.out.println("Retrieved data:"+registerEntity);

            registerEntity.setEmail("harish@123");
            registerEntity.setName("harish");

            RegisterEntity registerEntity1 = em.find(RegisterEntity.class,1);
            System.out.println("Update date:"+registerEntity1);


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
