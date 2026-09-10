package com.xworkz.services.impl;

import com.xworkz.dao.FoodItemDAO;
import com.xworkz.dao.impl.FoodItemDAOImpl;
import com.xworkz.dto.FoodItemDTO;
import com.xworkz.entity.FoodItemEntity;
import com.xworkz.services.FoodItemService;
import com.xworkz.utill.ValidationUtil;

import javax.validation.ConstraintViolation;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class FoodItemServiceImpl implements FoodItemService {

    FoodItemDAO foodItemDAO = new FoodItemDAOImpl();

    @Override
    public String saveAndValidate(FoodItemDTO foodItemDTO) {
        System.out.println("The saveandvalidate method is exicuting:"+foodItemDTO);

        String validate = "The data is not Validated";

        FoodItemEntity foodItemEntity = new FoodItemEntity();
        foodItemEntity.setName(foodItemDTO.getName());
        foodItemEntity.setPrice(foodItemDTO.getPrice());
        foodItemEntity.setDescription(foodItemDTO.getDescription());
        foodItemEntity.setCategory(foodItemDTO.getCategory());
        foodItemEntity.setAvailable(foodItemDTO.getAvailable());
        foodItemEntity.setQuantity(foodItemDTO.getQuantity());

        Boolean save = foodItemDAO.save(foodItemEntity);

        if(save){
            System.out.println("The data is saved. ");
        }else {
            System.out.println("The data is not saved.");
        }


        return validate;
    }

    @Override
    public String saveAndValidate(List<FoodItemDTO> foodItemDTOList) {
        String validate = "The data is not valid";

        List<FoodItemEntity> entityList = foodItemDTOList.stream()
                .map(FoodItemDTO -> new FoodItemEntity())
                .toList();

        Boolean status = foodItemDAO.saveAll(entityList);

        return validate;
    }

    @Override
    public String validateAndsaveFoodInfo(FoodItemDTO dto) {
        System.out.println("Runing ValidateAndsaveFoodInfo method in FoodItemServiceImpl");
        String isSavd = null;
        if(dto != null){
            Set<ConstraintViolation<FoodItemDTO>> validation = ValidationUtil.getValidator().validate(dto);
            System.out.println("Ref of constriantVoilation:" +validation);

            if(validation.isEmpty()){
                FoodItemEntity entity = new FoodItemEntity();
                entity.setName(dto.getName());
                entity.setPrice(dto.getPrice());
                entity.setDescription(dto.getDescription());
                entity.setCategory(dto.getCategory());
                entity.setAvailable(dto.getAvailable());
                entity.setQuantity(dto.getQuantity());
                entity.setVerity(dto.getVerity());

                Boolean result = foodItemDAO.saveFoodInfo(entity);

                if(result == true){
                    isSavd = "Data saved successfully in Table";
                }else{
                    isSavd = "Data is not saved";
                }
            }
        }
        return isSavd;
    }

    @Override
    public FoodItemDTO findFoodDTOById(Integer id) {
        System.out.println("The data is find by id");

        FoodItemDTO foodItemDTO = null;

        if(id != null){

            FoodItemEntity entity = foodItemDAO.getEntity(id);

            if(entity != null){
                foodItemDTO = new FoodItemDTO(entity.getName(),entity.getPrice(),entity.getDescription(),entity.getCategory(),entity.getAvailable(),entity.getQuantity(),"");
            }

        }else {
            foodItemDTO = null;
        }

        return foodItemDTO;
    }



    @Override
    public FoodItemDTO findFoodDTOByName(String name) {
        System.out.println();
        FoodItemDTO foodItemDTO = null;

        FoodItemEntity foodItemEntity = foodItemDAO.getEntiyByNmae(name);

        System.out.println("The Data:"+foodItemEntity);

        if(foodItemEntity != null){
            foodItemDTO = new FoodItemDTO(foodItemEntity.getName(), foodItemEntity.getPrice(), foodItemEntity.getDescription(), foodItemEntity.getCategory(), foodItemEntity.getAvailable(),foodItemEntity.getQuantity(),"");
        }

        return foodItemDTO;
    }

    @Override
    public String updateNameAndPriceById(String name, Double price, Integer id) {
        System.out.println("Invoking updateNameAndById : Service");
        String status = null;
        if (id != null && id > 0 && name != null && price != null) {
            Boolean isUpdated = foodItemDAO.updateNameAndPriceById(name, price, id);
            if (isUpdated) {
                status = "Data Updated";
            } else {
                status = "Data Not Updated";
            }
        }

        return status;
    }

    @Override
    public String updateQuantityByAvailable(Boolean available, Integer quatity) {
        System.out.println("Invoking updateQuantityByAvailable : Service");
        String status = null;
        if (available != null && quatity != null && quatity > 0) {
            Boolean isUpdated = foodItemDAO.updateQuantityByAvailable(available, quatity);
            if (isUpdated) {
                status = "Data Updated";
            } else {
                status = "Data Not Updated";
            }
        }

        return status;
    }

    @Override
    public List<String> getFoodName() {
        System.out.println("The get food names : service");

        List<String> foundNames = foodItemDAO.getFoodNames();

        if (foundNames != null){
            return foundNames;
        }
        return Collections.emptyList();
    }

    @Override
    public List<Object[]> getItemDiscriptionAndCetogary() {
        System.out.println("getItemDiscriptionAndCetogary : service");
        List<Object[]> food = foodItemDAO.getItemDiscriptionAndCetogary();
        if(food != null){
            return food;
        }
        return Collections.emptyList();
    }


    @Override
    public List<List<Object>> getFoodNameAndPrice() {
        System.out.println("getFoodNameAndPrice : Service");
        List<List<Object>> food = foodItemDAO.getFoodNameAndPrice();
        if(food != null){
            return food;
        }
        return Collections.emptyList();
    }
}
