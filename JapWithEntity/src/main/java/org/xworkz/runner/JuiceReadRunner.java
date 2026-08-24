package org.xworkz.runner;

import jakarta.persistence.*;
import org.xworkz.entity.JuiceEntity;

public class JuiceReadRunner {
    public static void main(String[] args) {

        EntityManagerFactory emf = null;
        EntityManager em = null;

        try{
            emf = Persistence.createEntityManagerFactory("akasha");
            em = emf.createEntityManager();

            JuiceEntity juiceEntity = em.find(JuiceEntity.class, 1);
            System.out.println("Retrieved entity:"+juiceEntity);



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
