package com.xworkz.runner;

import com.xworkz.dto.FoodItemDTO;
import com.xworkz.services.FoodItemService;
import com.xworkz.services.impl.FoodItemServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class FoodRunner {
    public static void main(String[] args) {

        FoodItemDTO foodItemDTO = new FoodItemDTO("Dosa",70,"Less gee","Breakfast",true,2);
        FoodItemService service = new FoodItemServiceImpl();
        service.saveAndValidate(foodItemDTO);

        List<FoodItemDTO> foodItemDTOList = new ArrayList<>();
        foodItemDTOList.add(new FoodItemDTO("Idli",45,"2 Type of Chatni","Breakfast",true,4));
        foodItemDTOList.add(new FoodItemDTO("Rice&Sambar",80,"Unlimited","Lunch",true,1));
        foodItemDTOList.add(new FoodItemDTO("Roti",70,"2 Type of palya","dinner",true,2));

        FoodItemService service1 = new FoodItemServiceImpl();
        service1.saveAndValidate(foodItemDTOList);

        //find by Id
        FoodItemDTO foodItemDTO1 = service1.findFoodDTOById(7);
        System.out.println("The entity:"+foodItemDTO1);

    }
}
