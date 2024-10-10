package com.example.demoboot.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
public class Role {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(name="role", nullable=false)
    private String role;

    @Column(name="description", nullable=false)
    private String description;

    @ManyToOne()
    @Column(name="users")
    private Set<User> users;

}
