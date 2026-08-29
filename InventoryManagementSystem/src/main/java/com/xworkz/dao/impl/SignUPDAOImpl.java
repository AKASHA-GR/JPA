package com.xworkz.dao.impl;

import com.xworkz.dao.SignUpDAO;
import com.xworkz.entity.SignUpEntity;

import javax.persistence.*;
import java.util.List;

public class SignUPDAOImpl implements SignUpDAO {
    @Override
    public Boolean save(SignUpEntity signUpEntity) {
        System.out.println("Invoking save SignUpImpl");
        Boolean isSaved = false;
        System.out.println("List of Entity :"+ signUpEntity);

        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;

        try{
            emf = Persistence.createEntityManagerFactory("akasha");
            em = emf.createEntityManager();
            et = em.getTransaction();
            et.begin();

            em.persist(signUpEntity);

            et.commit();

        }catch (PersistenceException e){
            e.getMessage();
            e.printStackTrace();
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
    public Boolean saveAll(List<SignUpEntity> sign) {
        System.out.println("Save the list of Data");

        Boolean isSaved = false;

        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et =null;


        try {
            emf = Persistence.createEntityManagerFactory("akasha");
            em = emf.createEntityManager();
            et = em.getTransaction();

            et.begin();

            for(SignUpEntity entity:sign){
                em.persist(entity);
            }

            isSaved = true;
            et.commit();

        } catch (PersistenceException e) {
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
    public SignUpEntity getSignEntity(Integer id) {
        System.out.println("geting Entity: Dto by id:"+id);
        SignUpEntity entity = null;
        EntityManagerFactory emf = null;

        try{
            entity = Persistence.createEntityManagerFactory("akasha").createEntityManager().find(SignUpEntity.class, id);
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

    @Override
    public SignUpEntity getSignEntity(String name) {
        System.out.println("geting Entity: Dto by name:"+name);
        SignUpEntity entity = null;
        EntityManagerFactory emf = null;

        try{
            entity = Persistence.createEntityManagerFactory("akasha").createEntityManager().find(SignUpEntity.class, name);
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
