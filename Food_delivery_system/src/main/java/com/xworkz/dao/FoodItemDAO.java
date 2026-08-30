package com.xworkz.dao;

import com.xworkz.entity.FoodItemEntity;

import java.util.List;

public interface FoodItemDAO {
    public Boolean save(FoodItemEntity foodItemEntity);

    public Boolean saveAll(List<FoodItemEntity> foodItemEntities);

    public FoodItemEntity getEntity(Integer id);
}
