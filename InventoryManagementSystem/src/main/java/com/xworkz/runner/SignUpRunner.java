package com.xworkz.runner;

import com.xworkz.dto.SignUpDTO;
import com.xworkz.services.SignUpService;
import com.xworkz.services.impl.SignUpServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class SignUpRunner {
    public static void main(String[] args) {
//single
        SignUpDTO signUpDTO = new SignUpDTO("prasad","prasad@23","Prasad@123",8764930237L);

        SignUpService signUpService = new SignUpServiceImpl();

        signUpService.saveAndValidate(signUpDTO);



        //multiple

        List<SignUpDTO> sign = new ArrayList<>();
        sign.add(new SignUpDTO("Harish","harish@gmaim","harish@123",2837649105L));
        sign.add(new SignUpDTO("Raghu","raghu@gmaim","raghu@123",2837649106L));
        sign.add(new SignUpDTO("prateek","prateek@gmaim","prateek@123",2837649107L));

        SignUpService signUpService1 = new SignUpServiceImpl();

        signUpService1.saveAndValidate(sign);


        //find by id
        SignUpDTO signUpDTO1 = signUpService1.findSignUpDTOById(8);
        System.out.println("Fount dto is:"+signUpDTO1);

    }
}
