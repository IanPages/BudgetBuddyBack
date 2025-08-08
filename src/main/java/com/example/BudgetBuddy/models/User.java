package com.example.BudgetBuddy.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotBlank(message = "Username is required")
    private String username;
    @NotBlank(message = "Email is required")
    private String email;

    @NotBlank(message = "Password is required")
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Account> accounts;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Category> categories;

}
