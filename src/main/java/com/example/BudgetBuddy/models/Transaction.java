package com.example.BudgetBuddy.models;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private BigDecimal amount;
    private String description;
    private LocalDate date;
    private TypeMovement type;

    @Enumerated(EnumType.STRING)
    private RecurrenceType recurrenceType;

    //if recurrenceType is custom, declares months
    private Integer recurrenceDuration;

    private LocalDate recurrenceEndDate;

    private LocalDate createdAt;


    @ManyToOne
    private Account account;

    @ManyToOne
    private Category category;


}
