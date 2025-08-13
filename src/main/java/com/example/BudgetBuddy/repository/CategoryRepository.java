package com.example.BudgetBuddy.repository;

import com.example.BudgetBuddy.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {


    Optional<Category> findByName(String name);

    @Query("SELECT c FROM Category c WHERE c.user.id = :userId OR c.isDefault = true")
    List<Category> findByUserIdOrDefault(Integer userId);


}
