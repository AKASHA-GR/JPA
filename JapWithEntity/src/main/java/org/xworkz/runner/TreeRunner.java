package org.xworkz.runner;

import jakarta.persistence.*;
import org.xworkz.entity.TreeEntity;

public class TreeRunner {
    public static void main(String[] args) {

        TreeEntity treeEntity = new TreeEntity();
        treeEntity.setTreeName("Mango");
        treeEntity.setTreeType("Fruit");

        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;

        try{
            emf = Persistence.createEntityManagerFactory("akasha");
            em = emf.createEntityManager();
            et = em.getTransaction();

            et.begin();
            em.persist(treeEntity);
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
