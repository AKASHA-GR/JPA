package com.xworkz.service.impl;

import com.xworkz.dao.CustomerDetailDAO;
import com.xworkz.dao.impl.CoustomerDetailDAOImpl;
import com.xworkz.dto.CustomerDetailDTO;
import com.xworkz.entity.CustomerDetailEntity;
import com.xworkz.service.CustomerService;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {

    CustomerDetailDAO customerDetailDAO = new CoustomerDetailDAOImpl();


    @Override
    public String validateAndSave(CustomerDetailDTO customerDetailDTO) {
        String isSaved = null;

        if(customerDetailDTO != null){
            CustomerDetailEntity customerDetailEntity = new CustomerDetailEntity();
            customerDetailEntity.setName(customerDetailDTO.getName());
            customerDetailEntity.setState(customerDetailDTO.getState());
            customerDetailEntity.setPincode(customerDetailDTO.getPincode());
            customerDetailEntity.setAccountNumber(customerDetailDTO.getAccountNumber());
            customerDetailEntity.setAccountType(customerDetailDTO.getAccountType());

            Boolean saved = customerDetailDAO.save(customerDetailEntity);

            if(saved){
                isSaved = "Data Saved";
            }else{
                isSaved = "Data is Empty";
            }
        } else{
            isSaved = "Data is Empty";
        }

        return isSaved;
    }

    @Override
    public String validateAndSave(List<CustomerDetailDTO> customerDetailDTOList) {

        String isSaved = null;

        if (customerDetailDTOList != null) {
            List<CustomerDetailEntity> customerDetailEntityList = customerDetailDTOList.stream()
                    .map(customerDetailDTO -> new CustomerDetailEntity(customerDetailDTO.getName(), customerDetailDTO.getState(), customerDetailDTO.getPincode(), customerDetailDTO.getAccountNumber(), customerDetailDTO.getAccountType()))
                    .toList();


            Boolean state = customerDetailDAO.saveAll(customerDetailEntityList);

            if (state) {
                isSaved = "The Data is Saved";
            } else {
                isSaved = "The Data is not saved";
            }

        }else {
            System.out.println("The data is empty");
        }
        return isSaved;
    }

    @Override
    public CustomerDetailDTO findById(Integer id) {
        System.out.println("Geting the data By Id:"+id);

        CustomerDetailDTO dto = null;
        if(id != null){
            CustomerDetailEntity customerDetailEntity = customerDetailDAO.getCustomerDetailEntity(id);

            if(customerDetailEntity != null){
                dto = new CustomerDetailDTO(customerDetailEntity.getName(), customerDetailEntity.getState(), customerDetailEntity.getPincode(), customerDetailEntity.getAccountNumber(), customerDetailEntity.getAccountType());
            }
        }else {
            dto = null;
        }

        return dto;
    }
}
