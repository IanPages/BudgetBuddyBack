package com.example.BudgetBuddy.dto.account;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ListAccount {

    private Integer id;

    private String name;

    private BigDecimal balance;

    private Boolean isMainAccount;

    private BigDecimal goalAmount;

    private LocalDate goalDeadLine;

    private LocalDate createdAt;

    private Integer userId;

    public ListAccount(){

    }
    public ListAccount(Integer id, String name, BigDecimal balance, Boolean isMainAccount, BigDecimal goalAmount, LocalDate goalDeadLine, LocalDate createdAt, Integer userId) {
        this.id = id;
        this.name = name;
        this.balance = balance;
        this.isMainAccount = isMainAccount;
        this.goalAmount = goalAmount;
        this.goalDeadLine = goalDeadLine;
        this.createdAt = createdAt;
        this.userId = userId;
    }

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
    public LocalDate getGoalDeadLine() {
        return goalDeadLine;
    }
    public void setGoalDeadLine(LocalDate goalDeadLine) {
        this.goalDeadLine = goalDeadLine;
    }
    public LocalDate getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }
    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

}
