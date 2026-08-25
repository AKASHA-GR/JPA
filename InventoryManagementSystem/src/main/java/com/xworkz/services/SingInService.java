package com.xworkz.services;

import com.xworkz.dto.SignInDTO;

public interface SingInService {
    public boolean validateAndSave(SignInDTO signInDTO
    );
}
