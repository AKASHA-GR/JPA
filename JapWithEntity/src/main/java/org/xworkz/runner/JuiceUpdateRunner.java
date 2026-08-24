package org.xworkz.runner;

import jakarta.persistence.*;
import org.xworkz.entity.JuiceEntity;

import java.text.ParseException;

public class JuiceUpdateRunner {
    public static void main(String[] args) {

        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;

        try{
            emf = Persistence.createEntityManagerFactory("akasha");
            em = emf.createEntityManager();
            et = em.getTransaction();

            et.begin();
            JuiceEntity juiceEntity = em.find(JuiceEntity.class,1);
            System.out.println("befor retrieving:"+juiceEntity);

            if(juiceEntity!=null){
                juiceEntity.setJuiceName("Apple");
                juiceEntity.setJuiceType("Apple");

                JuiceEntity juiceEntity1 = em.merge(juiceEntity);
                System.out.println("After retrieving:"+juiceEntity1);

            }


        }catch (PersistenceException e){
            e.getMessage();
        }finally {
            if(et != null){
                et.commit();
            }

            if(emf!= null){
                emf.close();
            }

            if(em!= null){
                em.close();
            }
        }

    }
}
