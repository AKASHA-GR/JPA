package org.xworkz.runner;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceException;
import org.xworkz.entity.TreeEntity;

public class TreeReadRunner {
    public static void main(String[] args) {

        EntityManagerFactory emf = null;
        EntityManager em = null;

        try{
            emf = Persistence.createEntityManagerFactory("akasha");
            em = emf.createEntityManager();

            TreeEntity treeEntity = em.find(TreeEntity.class,1);
            System.out.println("Retrieved Data:"+treeEntity);
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
