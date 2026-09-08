package com.xworkz.dto;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@ToString
@NoArgsConstructor

public class FoodItemDTO implements Serializable {
    private String name;
    private double price;
    private String description;
    private String category;
    private Boolean available;
    private Integer quantity;
    private String verity;

    public FoodItemDTO(String name, double price, String description, String category, Boolean available, Integer quantity, String verity) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.category = category;
        this.available = available;
        this.quantity = quantity;
        this.verity = verity;
    }
}
