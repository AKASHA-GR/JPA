package com.xworkz.dao.impl;

import com.xworkz.dao.CustomerDetailDAO;
import com.xworkz.dto.CustomerDetailDTO;
import com.xworkz.entity.CustomerDetailEntity;

import javax.persistence.*;
import java.util.List;

public class CoustomerDetailDAOImpl implements CustomerDetailDAO {
    @Override
    public Boolean save(CustomerDetailEntity coustomerDetailEntity) {
        System.out.println("The the single entity.");
        Boolean isSaved = false;

        EntityManagerFactory emf = null;
        EntityManager em  = null;
        EntityTransaction et = null;

        try{
            emf = Persistence.createEntityManagerFactory("akasha");
            em = emf.createEntityManager();
            et = em.getTransaction();

            et.begin();
            em.persist(coustomerDetailEntity);
            et.commit();
        }catch (PersistenceException e){
            e.getMessage();
            isSaved = false;

        }finally {
            if(emf != null){
                emf.close();
            }

            if(em != null){
                em.close();
            }
        }


        return isSaved;
    }

    @Override
    public Boolean saveAll(List<CustomerDetailEntity> customerDetailEntityList) {
        Boolean isSaved = false;

        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et =null;

        try{
            emf = Persistence.createEntityManagerFactory("akasha");
            em = emf.createEntityManager();
            et = em.getTransaction();

            et.begin();
            for(CustomerDetailEntity entity : customerDetailEntityList){
                em.persist(entity);
            }
            et.commit();
            isSaved = true;
        }catch (PersistenceException e) {
            e.getMessage();
            isSaved = false;
        }finally {
            if(emf != null){
                emf.close();
            }

            if(em != null){
                em.close();
            }
        }
        return isSaved;
    }

    @Override
    public CustomerDetailEntity getCustomerDetailEntity(Integer id) {
        System.out.println("The dto is find by id");

        CustomerDetailEntity entity = null;
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("akasha");
            em = emf.createEntityManager();
            entity = em.find(CustomerDetailEntity.class, id);
        }catch (PersistenceException e){
            e.getMessage();
            entity = null;
        }finally {
            if(em != null){
                em.close();
            }
            if(emf != null){
                emf.close();
            }
        }

        return entity;
    }
}
