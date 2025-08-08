package com.example.BudgetBuddy.models;

import jakarta.persistence.*;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;
    private Boolean isDefault;
    private TypeMovement type;

    //is NUll == everyone has that category
    @ManyToOne
    private User user;
}
