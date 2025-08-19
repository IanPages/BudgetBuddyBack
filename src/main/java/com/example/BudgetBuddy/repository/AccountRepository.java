package com.example.BudgetBuddy.repository;

import com.example.BudgetBuddy.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface AccountRepository extends JpaRepository<Account,Integer> {

    Optional<Account> findByUserId(Integer userId);
    Optional<Account> findByName(String name);
    Optional<Account> findByUserIdAndName(Integer userId, String name);


}
