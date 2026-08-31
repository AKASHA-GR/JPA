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
@Table(name = "booking_info")
public class BookingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "customer_Name")
    private String customerName;
    @Column(name = "phone_Number")
    private String phoneNumber;
    @Column(name = "email")
    private String email;
    @Column(name = "booking_Date")
    private LocalDate bookingDate;
    @Column(name = "booking_Time")
    private LocalTime bookingTime;
    @Column(name = "number_Of_Guests")
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
