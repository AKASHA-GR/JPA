package com.xworkz.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor

public class CustomerDetailDTO {
    private String name;
    private String state;
    private String pincode;
    private String accountNumber;
    private String accountType;
}
