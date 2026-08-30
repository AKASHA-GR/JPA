package com.xworkz.dto;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@ToString
@AllArgsConstructor

public class BookingDTO implements Serializable {
    private String customerName;
    private String phoneNumber;
    private String email;
    private LocalDate bookingDate;
    private LocalTime bookingTime;
    private Integer numberOfGuests;
}
