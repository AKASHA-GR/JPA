package com.xworkz.service;

import com.xworkz.dto.BookingDTO;

import java.util.List;

public interface BookService {
    public String validateAndSave(BookingDTO bookingDTO);
    public String validateAndSave(List<BookingDTO> bookingDTOList);
}
