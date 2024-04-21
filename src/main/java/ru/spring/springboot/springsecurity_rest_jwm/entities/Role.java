package ru.spring.springboot.springsecurity_rest_jwm.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column(name = "name")
    private String name;
}
