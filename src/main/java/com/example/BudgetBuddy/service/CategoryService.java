package com.example.BudgetBuddy.service;

import com.example.BudgetBuddy.dto.CreateCategory;
import com.example.BudgetBuddy.dto.ListCategory;
import com.example.BudgetBuddy.model.Category;
import com.example.BudgetBuddy.repository.CategoryRepository;
import com.example.BudgetBuddy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;
    private UserService userService;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository, UserService userService) {
        this.categoryRepository = categoryRepository;
        this.userService = userService;
    }

    public List<ListCategory> getCategoriesByUserId(Integer userId) {
       return categoryRepository.findByUserId(userId).stream()
               .map(cat -> new ListCategory(cat.getId(), cat.getName(), cat.getDefault(), cat.getType(), cat.getUser().getId()))
               .toList();
    }

    public Category createCategory(CreateCategory category) {
        Category newCategory = new Category();
        newCategory.setName(category.getName());
        newCategory.setDefault(false);
        newCategory.setType(category.getType());
        newCategory.setUser(userService.getUserById(category.getUserId()));
        return categoryRepository.save(newCategory);
    }

    public String categoryUpdate(Integer id, CreateCategory category) {
        if (categoryRepository.existsById(id)) {
            Category existingCategory = categoryRepository.findById(id).orElseThrow();
            existingCategory.setName(category.getName());
            existingCategory.setType(category.getType());
            existingCategory.setUser(userService.getUserById(category.getUserId()));
            categoryRepository.save(existingCategory);
            return "Category updated successfully.";
        }
        return "Category not found.";
    }

    public String deleteCategory(Integer id) {
        if(categoryRepository.existsById(id)) {
            categoryRepository.deleteById(id);
            return "Category deleted successfully.";
        }
        return "Category not found.";
    }

}
