package com.xworkz.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "foodItem_info")
@NamedQuery(name = "getAllFoodEntity",query = "select f from FoodItemEntity f")
@NamedQuery(name = "getEntityByName",query = "select f from FoodItemEntity f where name = :name")
@NamedQuery(name = "getEntityByPrice",query = "select f from FoodItemEntity f where price=:price")
@NamedQuery(name = "getEntityByCategory",query = "select f from FoodItemEntity f where category=:category")
@NamedQuery(name = "getEntityByQuantity",query = "select f from FoodItemEntity f where quantity=:quantity")

@NamedQuery(name = "updateByName",query = "update FoodItemEntity f set f.name= :name where f.id=:id")
@NamedQuery(name = "updateByAvailable",query = "u")
//@NamedQuery(name = "",query = "");
//@NamedQuery(name = "",query = "");

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
