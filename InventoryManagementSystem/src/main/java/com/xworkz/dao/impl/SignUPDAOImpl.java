package com.xworkz.dao.impl;

import com.xworkz.dao.SignUpDAO;
import com.xworkz.entity.SignUpEntity;

import javax.persistence.*;

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


}
