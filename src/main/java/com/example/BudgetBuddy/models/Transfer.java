package com.example.BudgetBuddy.models;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Transfer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private BigDecimal amount;
    private LocalDate date;
    private String description;

    @ManyToOne
    private Account fromAccount;

    @ManyToOne
    private Account toAccount;

    @ManyToOne
    private User user;
}
