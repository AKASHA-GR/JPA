package com.xworkz.services;

import com.xworkz.dto.SignUpDTO;

import java.util.List;

public interface SignUpService {
    public String saveAndValidate(SignUpDTO signUpDTO);

    public String saveAndValidate(List<SignUpDTO> sign);

    public SignUpDTO findSignUpDTOById(Integer id);



}
