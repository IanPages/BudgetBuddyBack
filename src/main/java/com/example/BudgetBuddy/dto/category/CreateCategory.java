package com.example.BudgetBuddy.dto.category;

import com.example.BudgetBuddy.model.TypeMovement;

public class CreateCategory {

    private String name;
    private TypeMovement type;
    private Integer userId;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TypeMovement getType() {
        return type;
    }

    public void setType(TypeMovement type) {
        this.type = type;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
