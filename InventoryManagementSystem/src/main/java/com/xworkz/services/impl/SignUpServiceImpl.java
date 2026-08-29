package com.xworkz.services.impl;

import com.xworkz.dao.SignUpDAO;
import com.xworkz.dao.impl.SignUPDAOImpl;
import com.xworkz.dto.SignUpDTO;
import com.xworkz.entity.SignUpEntity;
import com.xworkz.services.SignUpService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SignUpServiceImpl implements SignUpService {


    SignUpDAO signUpDAO = new SignUPDAOImpl();

    @Override
    public String saveAndValidate(SignUpDTO signUpDTO) {

        String isSaved = null;

        if(signUpDTO != null){
            SignUpEntity signUpEntity = new SignUpEntity();
            signUpEntity.setName(signUpDTO.getName());
            signUpEntity.setEmail(signUpDTO.getEmail());
            signUpEntity.setPassword(signUpDTO.getPassword());
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

    @Override
    public String saveAndValidate(List<SignUpDTO> sign) {

        String isSaved = null;

        if(sign != null){
            //List<SignUpEntity> listOfSignInEntity = new ArrayList<>();

//            for(SignUpDTO signUpDTO:sign){
//
//                SignUpEntity entity = new SignUpEntity();
//                entity.setName(signUpDTO.getName());
//                entity.setEmail(signUpDTO.getEmail());
//                entity.setPassword(signUpDTO.getPassword());
//                entity.setPhoneNumber(signUpDTO.getPhoneNumber());
//                listOfSignInEntity.add(entity);
//
//            }

            List<SignUpEntity> listOfSignInEntity = sign.stream()
                    .map(signUpDTO -> new SignUpEntity(signUpDTO.getName(),signUpDTO.getEmail(),signUpDTO.getPassword(),signUpDTO.getPhoneNumber())
                    ).collect(Collectors.toList());

            Boolean state = signUpDAO.saveAll(listOfSignInEntity);

            if(state){
                isSaved = "The Data is saved";
            }else{
                isSaved = "The Data is not saved";
            }
        }else {
            System.out.println("The data is empty");
        }

        return isSaved;
    }

    @Override
    public SignUpDTO findSignUpDTOById(Integer id) {
        System.out.println("Geting dto by ID:"+id);
        SignUpDTO dto = null;
        if(id != null){
            SignUpEntity entity = signUpDAO.getSignEntity(id);

            if(entity != null){
                dto = new SignUpDTO(entity.getName(), entity.getEmail(), entity.getPassword(), entity.getPhoneNumber());
            }
        }else {
            dto = null;
        }

        return dto;
    }

    @Override
    public SignUpDTO findSignUpDTOById(String name) {
        System.out.println("Geting dto by name:"+name);
        SignUpDTO dto = null;
        if(name != null){
            SignUpEntity entity = signUpDAO.getSignEntity(name);

            if(entity != null){
                dto = new SignUpDTO(entity.getName(), entity.getEmail(), entity.getPassword(), entity.getPhoneNumber());
            }
        }else {
            dto = null;
        }

        return dto;
    }
}
