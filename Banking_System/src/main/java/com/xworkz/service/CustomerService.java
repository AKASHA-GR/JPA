package com.xworkz.service;

import com.xworkz.dto.CustomerDetailDTO;

import java.util.List;

public interface CustomerService {

    public String validateAndSave(CustomerDetailDTO customerDetailDTO);

    public String validateAndSave(List<CustomerDetailDTO> customerDetailDTOList);

    CustomerDetailDTO findById(Integer id);

}
