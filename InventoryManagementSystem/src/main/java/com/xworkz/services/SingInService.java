package com.xworkz.services;

import com.xworkz.dto.SignInDTO;

import java.util.List;

public interface SingInService {
    public boolean validateAndSave(SignInDTO signInDTO);

    public String validateAndSave(List<SignInDTO> signInDTOList);
}
