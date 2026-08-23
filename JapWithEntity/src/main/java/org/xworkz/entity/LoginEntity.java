package org.xworkz.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@Entity
@Table(name = "login_entity")
public class LoginEntity {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "login_id")
    private int loginId;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
}
