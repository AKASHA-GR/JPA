package com.xworkz.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class BookingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "customerName")
    private String customerName;
    @Column(name = "phoneNumber")
    private String phoneNumber;
    @Column(name = "email")
    private String email;
    @Column(name = "bookingDate")
    private LocalDate bookingDate;
    @Column(name = "bookingTime")
    private LocalTime bookingTime;
    @Column(name = "numberOfGuests")
    private Integer numberOfGuests;

    public BookingEntity(String customerName, String phoneNumber, String email, LocalDate bookingDate, LocalTime bookingTime, Integer numberOfGuests) {
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.bookingDate = bookingDate;
        this.bookingTime = bookingTime;
        this.numberOfGuests = numberOfGuests;
    }
}
