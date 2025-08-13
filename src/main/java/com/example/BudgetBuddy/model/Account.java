package com.example.BudgetBuddy.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotBlank(message = "Name cannot be blank")
    private String name;
    @NotNull(message = "Balance cannot be null")
    private BigDecimal balance;

    //False == saving account
    private Boolean isMainAccount;

    //Only for saving accounts
    private BigDecimal goalAmount;
    private LocalDate goalDeadline;

    private LocalDate createdAt;

    @ManyToOne
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

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Boolean getMainAccount() {
        return isMainAccount;
    }

    public void setMainAccount(Boolean mainAccount) {
        isMainAccount = mainAccount;
    }

    public BigDecimal getGoalAmount() {
        return goalAmount;
    }

    public void setGoalAmount(BigDecimal goalAmount) {
        this.goalAmount = goalAmount;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getGoalDeadline() {
        return goalDeadline;
    }

    public void setGoalDeadline(LocalDate goalDeadline) {
        this.goalDeadline = goalDeadline;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
