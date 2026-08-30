package com.xworkz.dao.impl;

import com.xworkz.dao.BookingDAO;
import com.xworkz.entity.BookingEntity;

import javax.persistence.*;
import java.util.List;

public class BookingDAOImpl implements BookingDAO {
    @Override
    public Boolean save(BookingEntity bookingEntity) {
        System.out.println("The saving the Entity to DB.");
        Boolean save = false;

        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;

        try{
            emf = Persistence.createEntityManagerFactory("akasha");
            em = emf.createEntityManager();
            et = em.getTransaction();

            et.begin();
            em.persist(bookingEntity);
            et.commit();
        }catch (PersistenceException e) {
            e.printStackTrace();
            save = false;
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

        return save;
    }

    @Override
    public Boolean saveAll(List<BookingEntity> bookingEntityList) {
        System.out.println("The list of bookingEntitis are saved");
        Boolean isSaved = false;

        EntityManagerFactory emf =null;
        EntityManager em = null;
        EntityTransaction et = null;

        try{
            emf = Persistence.createEntityManagerFactory("akasha");
            em = emf.createEntityManager();
            et = em.getTransaction();

            et.begin();

            for (BookingEntity entity:bookingEntityList){
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
}
