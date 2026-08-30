package com.xworkz.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "foodItem_info")
public class FoodItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "itemName")
    private String name;
    @Column(name = "itemPrice")
    private double price;
    @Column(name = "itemDescription")
    private String description;
    @Column(name = "itemCategory")
    private String category;
    @Column(name = "status")
    private Boolean available;
    @Column(name = "quantity")
    private Integer quantity;

    public FoodItemEntity(String name, double price, String description, String category, Boolean available, Integer quantity) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.category = category;
        this.available = available;
        this.quantity = quantity;
    }
}
