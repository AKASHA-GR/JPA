package com.xworkz.runner;

import com.xworkz.dto.CustomerDetailDTO;
import com.xworkz.service.CustomerService;
import com.xworkz.service.impl.CustomerServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class CustomerDetailRunner {
    public static void main(String[] args) {

        //single
        CustomerDetailDTO customerDetailDTO = new CustomerDetailDTO("Hemanth","Karnataka","645263","26328239","Saving");
        CustomerService customerService = new CustomerServiceImpl();
        customerService.validateAndSave(customerDetailDTO);

        //multiple
        List<CustomerDetailDTO> customerDetailDTOList = new ArrayList<>();
        customerDetailDTOList.add(new CustomerDetailDTO("Hemanth","Karnataka","645263","26328239","Saving"));
        customerDetailDTOList.add(new CustomerDetailDTO("Rahul","Maharashtra","400001","12345678","Current"));
        customerDetailDTOList.add(new CustomerDetailDTO("Priya","TamilNadu","600001","87654321","Saving"));
        customerDetailDTOList.add(new CustomerDetailDTO("Amit","Delhi","110001","54321678","Current"));
        customerDetailDTOList.add(new CustomerDetailDTO("Sneha","Kerala","680001","98765432","Saving"));
        customerDetailDTOList.add(new CustomerDetailDTO("Vikram","Gujarat","380001","11223344","Current"));
        customerService.validateAndSave(customerDetailDTOList);

        //findbyid
        CustomerService customerService1 = new CustomerServiceImpl();
        CustomerDetailDTO customerDetailDTO1 = customerService1.findById(4);
        System.out.println("found dto is:"+customerDetailDTO1);
    }
}
