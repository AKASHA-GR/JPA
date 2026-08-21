package org.xworkz.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "tree_details")
public class TreeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tree_number")
    private int treeNumber;
    @Column(name = "tree_name")
    private String treeName;
    @Column(name = "tree_type")
    private String treeType;
}
