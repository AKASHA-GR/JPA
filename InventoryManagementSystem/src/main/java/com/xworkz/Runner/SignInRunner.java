package com.xworkz.Runner;

import com.xworkz.dto.SignInDTO;
import com.xworkz.services.SingInService;
import com.xworkz.services.impl.SingInServiceImpl;

public class SignInRunner {
    public static void main(String[] args) {

        SignInDTO signInDTO = new SignInDTO("Pavan","Pavan@gmail.com");

        SingInService singInService = new SingInServiceImpl();

        singInService.validateAndSave(signInDTO);

    }
}
