package com.xworkz.dto;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class SignUpDTO implements Serializable {
    private String name;
    private String email;
    private String password;
    private long phoneNumber;

    public SignUpDTO(String name, String email, String password, long phoneNumber) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }
}
