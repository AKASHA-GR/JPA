package org.xworkz.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "shoes_info")
public class ShoesEntity {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "shoes_id")
    private int shoesId;
    @Column(name = "shoes_name")
    private String shoesName;
    @Column(name = "shoes_type")
    private String shoesType;

}
