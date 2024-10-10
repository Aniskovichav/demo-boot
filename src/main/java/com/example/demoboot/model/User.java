package com.example.demoboot.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(name="username", nullable=false)
    private String username;

    @Column(name="password", nullable=false)
    private String password;

    @Column(name="email", nullable=false)
    private String email;

    @Column(name="role", nullable=false)
    private Role role;

}
