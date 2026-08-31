package com.xworkz.dao;

import com.xworkz.dto.CustomerDetailDTO;
import com.xworkz.entity.CustomerDetailEntity;

import java.util.List;

public interface CustomerDetailDAO {

    public Boolean save(CustomerDetailEntity coustomerDetailEntity );

    public Boolean saveAll(List<CustomerDetailEntity> customerDetailEntityList);

    public CustomerDetailEntity getCustomerDetailEntity(Integer id);
}
