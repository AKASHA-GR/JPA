package com.xworkz.services.impl;

import com.xworkz.dao.SignInDAO;
import com.xworkz.dao.SignInDAOImpl;
import com.xworkz.dto.SignInDTO;
import com.xworkz.entity.SignInEntity;
import com.xworkz.services.SingInService;

public class SingInServiceImpl implements SingInService {
    @Override
    public boolean validateAndSave(SignInDTO signInDTO) {

        System.out.println("Validating and saving SignInDTO: " + signInDTO);

        SignInEntity signInEntity = null;
        if(signInDTO != null){
            signInEntity = new SignInEntity();
            signInEntity.setUserName(signInDTO.getUserName());
            signInEntity.setEmail(signInDTO.getEmail());
        }

        SignInDAO signInDAO = new SignInDAOImpl();
        return signInDAO.save(signInEntity);
    }
}
