package org.xworkz.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@ToString
@NoArgsConstructor
@Data
@Entity
@Table(name = "juice_info")
public class JuiceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "juice_id")
    private int juiceId;
    @Column(name = "juice_name")
    private String juiceName;
    @Column(name = "juice_type")
    private String juiceType;
}
