package com.example.demoboot.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(name="role", nullable=false)
    private String role;

    @Column(name="description", nullable=false)
    private String description;


}
