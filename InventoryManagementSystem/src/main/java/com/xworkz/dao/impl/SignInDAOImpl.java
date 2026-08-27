package com.xworkz.dao.impl;

import com.xworkz.dao.SignInDAO;
import com.xworkz.entity.SignInEntity;

import javax.persistence.*;

public class SignInDAOImpl implements SignInDAO {
    @Override
    public boolean save(SignInEntity signInEntity){
        System.out.println("The save method is running on SignInDAOImpl.");
        System.out.println("SignIn Entity: " + signInEntity);
        Boolean isSaved = false;
        EntityManagerFactory emf = null;
        EntityManager em =null;
        EntityTransaction et = null;

        try{
            emf = Persistence.createEntityManagerFactory("akasha");
            em = emf.createEntityManager();
            et = em.getTransaction();

            et.begin();
            System.out.println("Transaction started, persisting entity: " + signInEntity);

            em.persist(signInEntity);
            System.out.println("Entity persisted successfully");

            et.commit();
            System.out.println("Transaction committed successfully");
        }catch (PersistenceException e){
            e.printStackTrace();
            if(et != null && et.isActive()){
                et.rollback();
            }
            return isSaved;
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
