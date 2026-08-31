package com.xworkz.runner;

import com.xworkz.dto.BookingDTO;
import com.xworkz.service.BookService;
import com.xworkz.service.impl.BookServiceImpl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class BookingRunner {
    public static void main(String[] args) {

        BookingDTO bookingDTO = new BookingDTO("Varada","837465296","varada@gmail.com", LocalDate.of(2026,8,31), LocalTime.of(10,30),5);
        BookService service = new BookServiceImpl();
        service.validateAndSave(bookingDTO);

        List<BookingDTO> bookingDTOList = new ArrayList<>();
        bookingDTOList.add(new BookingDTO("Manjunath","8367482945","manju@gmail.com",LocalDate.of(2026,6,4),LocalTime.of(11,30),4));
        bookingDTOList.add(new BookingDTO("Yamini","5376286384","yamini@gmail.com",LocalDate.of(2026,9,11),LocalTime.of(4,30),3));
        bookingDTOList.add(new BookingDTO("Varsha","8298374937","versha@gmail.com",LocalDate.of(2026,11,27),LocalTime.of(1,30),6));

        BookService service1 = new BookServiceImpl();
        service1.validateAndSave(bookingDTOList);

    }
}
