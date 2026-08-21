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
@Table(name = "register_details")
public class RegisterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "register_id")
    private int registerId;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
}
