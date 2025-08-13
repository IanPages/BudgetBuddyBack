package com.example.BudgetBuddy.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    @ManyToOne(fetch= FetchType.LAZY)
    @JsonBackReference
    private User user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getDefault() {
        return isDefault;
    }

    public void setDefault(Boolean aDefault) {
        isDefault = aDefault;
    }

    public TypeMovement getType() {
        return type;
    }

    public void setType(TypeMovement type) {
        this.type = type;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Category(Integer id, String name,Boolean isDefault,TypeMovement type, User user ) {
        this.isDefault = isDefault;
        this.user = user;
        this.type = type;
        this.name = name;
        this.id = id;
    }
    public Category() {
        // Default constructor
    }
}
