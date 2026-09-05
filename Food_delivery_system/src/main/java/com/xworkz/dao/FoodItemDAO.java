package com.xworkz.dao;

import com.xworkz.entity.FoodItemEntity;

import java.util.List;

public interface FoodItemDAO {
    public Boolean save(FoodItemEntity foodItemEntity);

    public Boolean saveAll(List<FoodItemEntity> foodItemEntities);

    public FoodItemEntity getEntity(Integer id);

    public FoodItemEntity getEntiyByNmae(String name);

    public FoodItemEntity getEntityByPrice(Double price);

    public FoodItemEntity getEntityByCategory(String category);

    public FoodItemEntity getEntityByQuantity(Integer quantity);

    //update
    public Boolean updateNameAndPriceById(String name, Double price, Integer id);
    public Boolean updateQuantityByAvailable(Boolean available, Integer quatity);

    //col list
    List<String> getFoodNames();

    List<Object[]> getItemDiscriptionAndCetogary();

    List<List<Object>> getFoodNameAndPrice();
}
