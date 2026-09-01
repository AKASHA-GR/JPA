package com.xworkz.services;

import com.xworkz.dto.FoodItemDTO;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface FoodItemService {
    public String saveAndValidate(FoodItemDTO foodItemDTO);

    public String saveAndValidate(List<FoodItemDTO> foodItemDTOList);

    public FoodItemDTO findFoodDTOById(Integer id);

    public FoodItemDTO findFoodDTOByName(String name);
}
