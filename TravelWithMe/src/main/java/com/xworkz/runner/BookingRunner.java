package com.xworkz.runner;

import com.xworkz.dto.BookingDTO;
import com.xworkz.service.BookService;
import com.xworkz.service.impl.BookServiceImpl;

import java.time.LocalDate;
import java.time.LocalTime;

public class BookingRunner {
    public static void main(String[] args) {

        BookingDTO bookingDTO = new BookingDTO("Varada","837465296","varada@gmail.com", LocalDate.of(2026,8,31), LocalTime.of(10,30),5);
        BookService service = new BookServiceImpl();
        service.validateAndSave(bookingDTO);

    }
}
