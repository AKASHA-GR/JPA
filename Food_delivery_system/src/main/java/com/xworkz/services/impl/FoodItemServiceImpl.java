package com.xworkz.services.impl;

import com.xworkz.dao.FoodItemDAO;
import com.xworkz.dao.impl.FoodItemDAOImpl;
import com.xworkz.dto.FoodItemDTO;
import com.xworkz.entity.FoodItemEntity;
import com.xworkz.services.FoodItemService;

import java.util.List;

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
                .map(FoodItemDTO -> new FoodItemEntity(FoodItemDTO.getName(), FoodItemDTO.getPrice(),FoodItemDTO.getDescription(),FoodItemDTO.getCategory(),FoodItemDTO.getAvailable(),FoodItemDTO.getQuantity()))
                .toList();

        Boolean status = foodItemDAO.saveAll(entityList);

        return validate;
    }

    @Override
    public FoodItemDTO findFoodDTOById(Integer id) {
        System.out.println("The data is find by id");

        FoodItemDTO foodItemDTO = null;

        if(id != null){

            FoodItemEntity entity = foodItemDAO.getEntity(id);

            if(entity != null){
                foodItemDTO = new FoodItemDTO(entity.getName(),entity.getPrice(),entity.getDescription(),entity.getCategory(),entity.getAvailable(),entity.getQuantity());
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
            foodItemDTO = new FoodItemDTO(foodItemEntity.getName(), foodItemEntity.getPrice(), foodItemEntity.getDescription(), foodItemEntity.getCategory(), foodItemEntity.getAvailable(),foodItemEntity.getQuantity());
        }

        return foodItemDTO;
    }
}
