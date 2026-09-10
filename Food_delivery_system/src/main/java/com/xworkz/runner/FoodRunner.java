package com.xworkz.runner;

import com.xworkz.dao.FoodItemDAO;
import com.xworkz.dao.impl.FoodItemDAOImpl;
import com.xworkz.dto.FoodItemDTO;
import com.xworkz.services.FoodItemService;
import com.xworkz.services.impl.FoodItemServiceImpl;
import lombok.NonNull;

import javax.persistence.Column;
import java.util.ArrayList;
import java.util.List;

public class FoodRunner {
    public static void main(String[] args) {

//        FoodItemDTO foodItemDTO = new FoodItemDTO("Dosa",70,"Less gee","Breakfast",true,2);
//        FoodItemService service = new FoodItemServiceImpl();
//        service.saveAndValidate(foodItemDTO);
//
//        List<FoodItemDTO> foodItemDTOList = new ArrayList<>();
//        foodItemDTOList.add(new FoodItemDTO("Idli",45,"2 Type of Chatni","Breakfast",true,4));
//        foodItemDTOList.add(new FoodItemDTO("Rice&Sambar",80,"Unlimited","Lunch",true,1));
//        foodItemDTOList.add(new FoodItemDTO("Roti",70,"2 Type of palya","dinner",true,2));
//        foodItemDTOList.add(new FoodItemDTO("Pulao",120,"Spicy","Lunch",true,3));
//        foodItemDTOList.add(new FoodItemDTO("Veg Biryani",150,"Aromatic","Dinner",true,2));
//        foodItemDTOList.add(new FoodItemDTO("Curd Rice",50,"Cooling","Lunch",true,5));
//
        FoodItemService service1 = new FoodItemServiceImpl();
////        service1.saveAndValidate(foodItemDTOList);
////
////        //find by Id
//        FoodItemDTO foodItemDTO1 = service1.findFoodDTOById(7);
//        System.out.println("The entity:"+foodItemDTO1);
//
//        //find ny name
//        FoodItemDTO foodItemDTO2 = service1.findFoodDTOByName("adc");
//        System.out.println("The found name:"+foodItemDTO2);


        //update
//        String updateStatus1 = service1.updateNameAndPriceById("Dosa", 85.0, 7);
//        System.out.println("Update Name and Price Status: " + updateStatus1);
//
//        String updateStatus2 = service1.updateQuantityByAvailable(true, 10);
//        System.out.println("Update Quantity by Available Status: " + updateStatus2);


//         //single column
//        List<String> names = service1.getFoodName();
//        System.out.println(names);
//
//        //single column using array
//        List<Object[]> food1 = service1.getItemDiscriptionAndCetogary();
//        for(Object[] food : food1){
//            System.out.println("Discription:"+food[0]);
//            System.out.println("Cetogary:"+food[1]);
//        }

        //single column using List<Object>
//
//        FoodItemDAO foodItemDAO = new FoodItemDAOImpl();
//        boolean result = foodItemDAO.updateVerity();
//
//        System.out.println("Verity update:"+result);

        System.out.println("---save the dto though validation in service---");
        FoodItemService foodItemService = new FoodItemServiceImpl();
        FoodItemDTO foodItemDTO = new FoodItemDTO();
        foodItemDTO.setName("Pongal");
        foodItemDTO.setPrice(45);
        foodItemDTO.setDescription("with chatni and mirchi");
        foodItemDTO.setCategory("Breakfast");
        foodItemDTO.setAvailable(true);
        foodItemDTO.setQuantity(2);
        foodItemDTO.setVerity("3 type");
        String res = foodItemService.validateAndsaveFoodInfo(foodItemDTO);
        System.out.println("result of validated save:---"+res);

    }
}
