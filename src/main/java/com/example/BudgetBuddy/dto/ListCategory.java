package com.example.BudgetBuddy.dto;

import com.example.BudgetBuddy.model.TypeMovement;

public class ListCategory {

    private Integer id;
    private String name;
    private Boolean isDefault;
    private TypeMovement type;
    private Integer userId;

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
    public void setDefault(Boolean isDefault) {
        this.isDefault = isDefault;
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

    public ListCategory(Integer id,String name ,Boolean isDefault, TypeMovement type,Integer userId) {
        this.id = id;
        this.userId = userId;
        this.type = type;
        this.isDefault = isDefault;
        this.name = name;
    }
}
