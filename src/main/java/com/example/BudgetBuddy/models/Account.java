package com.example.BudgetBuddy.models;


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
    private User user;


}
