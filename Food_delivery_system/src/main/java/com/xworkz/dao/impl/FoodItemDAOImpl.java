package com.xworkz.dao.impl;

import com.xworkz.dao.FoodItemDAO;
import com.xworkz.entity.FoodItemEntity;

import javax.persistence.*;
import java.util.List;


public class FoodItemDAOImpl implements FoodItemDAO {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("akasha");

    @Override
    public Boolean save(FoodItemEntity foodItemEntity) {
        System.out.println("The save the foodItemEntity:"+foodItemEntity);

        Boolean isSaved = false;
        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;

        try {
            emf = Persistence.createEntityManagerFactory("akasha");
            em = emf.createEntityManager();
            et = em.getTransaction();

            et.begin();
            em.persist(foodItemEntity);
            isSaved = true;
            et.commit();

        } catch (PersistenceException e) {
            e.printStackTrace();
            isSaved = false;
            if (et != null && et.isActive()) {
                et.rollback();
            }
        } finally {
            if(emf != null){
                emf.close();
            }
            if (em != null) {
                em.close();
            }
        }

        return isSaved;
    }

    @Override
    public Boolean saveAll(List<FoodItemEntity> foodItemEntities) {
        System.out.println("The list of fooditementity is saved:"+foodItemEntities);

        Boolean isSaved = false;

        EntityManagerFactory emf =null;
        EntityManager em = null;
        EntityTransaction et = null;

        try{
            emf = Persistence.createEntityManagerFactory("akasha");
            em = emf.createEntityManager();
            et = em.getTransaction();

            et.begin();

            for (FoodItemEntity entity:foodItemEntities){
                em.persist(entity);
            }

            et.commit();
        }catch (PersistenceException e){
            e.getMessage();

            if(et != null && et.isActive()){
                et.rollback();
            }
        }

        return isSaved;
    }

    @Override
    public FoodItemEntity getEntity(Integer id) {
        System.out.println("Getting the by id:"+id);
        FoodItemEntity entity = null;
        EntityManagerFactory emf = null;

        try{
            entity = Persistence.createEntityManagerFactory("akasha").createEntityManager().find(FoodItemEntity.class, id);
        }catch (PersistenceException e){
            e.printStackTrace();
            entity = null;
        }finally {
            if(emf != null){
                emf.close();
            }
        }

        return entity;
    }
}
