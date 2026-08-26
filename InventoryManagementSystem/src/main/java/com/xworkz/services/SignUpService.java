package com.xworkz.services;

import com.xworkz.dto.SignUpDTO;

public interface SignUpService {
    public String saveAndValidate(SignUpDTO signUpDTO);
}
