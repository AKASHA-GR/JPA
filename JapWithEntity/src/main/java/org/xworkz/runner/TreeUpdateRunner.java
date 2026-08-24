package org.xworkz.runner;

import jakarta.persistence.*;
import org.xworkz.entity.TreeEntity;

import java.text.ParseException;

public class TreeUpdateRunner {
    public static void main(String[] args) {

        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;

        try{
            emf = Persistence.createEntityManagerFactory("akasha");
            em = emf.createEntityManager();
            et = em.getTransaction();

            et.begin();

            TreeEntity treeEntity = em.find(TreeEntity.class, 1);
            System.out.println("The retrieve data"+treeEntity);

            treeEntity.setTreeName("Rain Tree");
            treeEntity.setTreeType("Normal tree");

            TreeEntity treeEntity1 = em.find(TreeEntity.class, 1);
            System.out.println("The update data"+treeEntity1);


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
