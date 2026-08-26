package com.xworkz;

import com.xworkz.dto.SignUpDTO;
import com.xworkz.services.SignUpService;
import com.xworkz.services.impl.SignUpServiceImpl;

public class SignUpRunner {
    public static void main(String[] args) {

        SignUpDTO signUpDTO = new SignUpDTO("prasad","prasad@23","Prasad@123",8764930237L);

        SignUpService signUpService = new SignUpServiceImpl();

        signUpService.saveAndValidate(signUpDTO);

    }
}
