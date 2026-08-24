package org.xworkz.runner;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceException;
import org.xworkz.entity.RegisterEntity;

public class RegisterReadRunner {
    public static void main(String[] args) {

        EntityManagerFactory emf = null;
        EntityManager em = null;

        try{
            emf = Persistence.createEntityManagerFactory("akasha");
            em = emf.createEntityManager();

            RegisterEntity registerEntity = em.find(RegisterEntity.class,1);
            System.out.println("Retrieve data:"+registerEntity);


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
