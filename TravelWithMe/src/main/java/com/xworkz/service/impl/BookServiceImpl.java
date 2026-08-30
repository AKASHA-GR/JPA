package com.xworkz.service.impl;

import com.xworkz.dao.BookingDAO;
import com.xworkz.dao.impl.BookingDAOImpl;
import com.xworkz.dto.BookingDTO;
import com.xworkz.entity.BookingEntity;
import com.xworkz.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {

    BookingDAO bookingDAO = new BookingDAOImpl();

    @Override
    public String validateAndSave(BookingDTO bookingDTO) {
        System.out.println("Validate the DTO");

        String validate = "The dto is not valid";

        BookingEntity bookingEntity = new BookingEntity();
        bookingEntity.setCustomerName(bookingDTO.getCustomerName());
        bookingEntity.setPhoneNumber(bookingDTO.getPhoneNumber());
        bookingEntity.setEmail(bookingDTO.getEmail());
        bookingEntity.setBookingDate(bookingDTO.getBookingDate());
        bookingEntity.setBookingTime(bookingDTO.getBookingTime());
        bookingEntity.setNumberOfGuests(bookingDTO.getNumberOfGuests());

        Boolean saved = bookingDAO.save(bookingEntity);

        if(saved){
            System.out.println("The data is saved. ");
        }else {
            System.out.println("The data is not saved.");
        }


        return validate;
    }

    @Override
    public String validateAndSave(List<BookingDTO> bookingDTOList) {
        String validate = "The data is not valid";

        List<BookingEntity> entityList = bookingDTOList.stream()
                .map(BookingDTO -> new BookingEntity(BookingDTO.getCustomerName(), BookingDTO.getPhoneNumber(), BookingDTO.getEmail(), BookingDTO.getBookingDate(), BookingDTO.getBookingTime(), BookingDTO.getNumberOfGuests()))
                .toList();

        Boolean status = bookingDAO.saveAll(entityList);

        return validate;
    }
}
