package com.xworkz.services.impl;

import com.xworkz.dao.SignUpDAO;
import com.xworkz.dao.impl.SignUPDAOImpl;
import com.xworkz.dto.SignUpDTO;
import com.xworkz.entity.SignUpEntity;
import com.xworkz.services.SignUpService;

public class SignUpServiceImpl implements SignUpService {


    SignUpDAO signUpDAO = new SignUPDAOImpl();

    @Override
    public String saveAndValidate(SignUpDTO signUpDTO) {

        String isSaved = null;

        if(signUpDTO != null){
            SignUpEntity signUpEntity = new SignUpEntity();
            signUpEntity.setName(signUpDTO.getName());
            signUpEntity.setEmail(signUpDTO.getEmail());
            signUpEntity.setPassword(signUpEntity.getPassword());
            signUpEntity.setPhoneNumber(signUpDTO.getPhoneNumber());
            Boolean saved = signUpDAO.save(signUpEntity);

            if(saved){
                isSaved = "Data Saved";
            }else {
                isSaved = "Data is Empty";
            }

        } else{
            isSaved = "Data is Empty";
        }

        return isSaved;
    }
}
