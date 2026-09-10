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

@NamedQuery(name = "updateNameAndPriceById",query = "update FoodItemEntity f set f.name= :name, f.price=:price where f.id=:id")
@NamedQuery(name = "updateQuantityByAvailable",query = "update FoodItemEntity f set f.quantity=:quantity where f.available=:available ")

@NamedQuery(name = "updateVerityColumn",query = "select f from FoodItemEntity f where verity is null")

public class FoodItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "itemName")
    @NonNull
    private String name;
    @Column(name = "itemPrice")
    @NonNull
    private double price;
    @Column(name = "itemDescription")
    @NonNull
    private String description;
    @Column(name = "itemCategory")
    @NonNull
    private String category;
    @Column(name = "status")
    @NonNull
    private Boolean available;
    @Column(name = "quantity")
    @NonNull
    private Integer quantity;
    @NonNull
    private String verity;

    public FoodItemEntity() {
        this.name = name;
        this.price = price;
        this.description = description;
        this.category = category;
        this.available = available;
        this.quantity = quantity;
    }
}
