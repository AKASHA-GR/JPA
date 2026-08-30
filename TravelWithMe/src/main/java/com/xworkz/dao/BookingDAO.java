package com.xworkz.dao;

import com.xworkz.entity.BookingEntity;

import java.util.List;

public interface BookingDAO {
    public Boolean save(BookingEntity bookingEntity);

    public Boolean saveAll(List<BookingEntity> bookingEntityList);

}
