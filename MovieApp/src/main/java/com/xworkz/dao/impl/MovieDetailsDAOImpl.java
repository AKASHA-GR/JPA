package com.xworkz.dao.impl;

import com.xworkz.dao.MovieDetailsDAO;
import com.xworkz.entity.MovieDetailsEntity;

import javax.persistence.*;
import java.util.List;

public class MovieDetailsDAOImpl implements MovieDetailsDAO {

    @Override
    public Boolean save(MovieDetailsEntity movieDetailsEntity) {
        Boolean save = false;

        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;

        try{
            emf = Persistence.createEntityManagerFactory("akasha");
            em = emf.createEntityManager();
            et = em.getTransaction();

            et.begin();
            em.persist(movieDetailsEntity);
            et.commit();
            save = true;
        }catch (PersistenceException e){
            e.getMessage();
            et.rollback();
        }finally {
            if(emf != null){
                emf.close();
            }

            if(em != null){
                em.close();
            }
        }

        return save;
    }

    @Override
    public Boolean saveAll(List<MovieDetailsEntity> movieDetailsEntityList) {
        Boolean save = false;

        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;

        try{
            emf = Persistence.createEntityManagerFactory("akasha");
            em = emf.createEntityManager();
            et = em.getTransaction();

            et.begin();
            for(MovieDetailsEntity entity:movieDetailsEntityList){
                em.persist(entity);
            }

            et.commit();
            save = true;
        }catch (PersistenceException e){
            e.getMessage();
            et.rollback();
        }finally {
            if(emf != null){
                emf.close();
            }

            if(em != null){
                em.close();
            }
        }

        return save;
    }
}
