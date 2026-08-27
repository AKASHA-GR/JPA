package com.xworkz.dto;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@ToString


public class SignInDTO implements Serializable{
    private String userName;
    private String email;

    public SignInDTO(String userName, String email) {
        this.userName = userName;
        this.email = email;
    }
}
