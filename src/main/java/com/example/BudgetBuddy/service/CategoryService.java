package com.example.BudgetBuddy.service;

import com.example.BudgetBuddy.dto.CreateCategory;
import com.example.BudgetBuddy.dto.ListCategory;
import com.example.BudgetBuddy.model.Category;
import com.example.BudgetBuddy.repository.CategoryRepository;
import com.example.BudgetBuddy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;
    private UserService userService;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository, UserService userService) {
        this.categoryRepository = categoryRepository;
        this.userService = userService;
    }

    public ListCategory getCategoryById(Integer id){
        return categoryRepository.findById(id).map(cat -> new ListCategory(cat.getId(), cat.getName(), cat.getDefault(), cat.getType(),
                cat.getUser() != null ? cat.getUser().getId() : null)).orElseThrow(() -> new RuntimeException("Category not found"));
    }

    public List<ListCategory> getCategoriesByUserId(Integer userId) {
       return categoryRepository.findByUserIdOrDefault(userId).stream()
               .map(cat -> new ListCategory(cat.getId(), cat.getName(), cat.getDefault(), cat.getType(),
                       cat.getUser() != null ? cat.getUser().getId() : null))
               .toList();
    }

    public Category createCategory(CreateCategory category) {
        Category newCategory = new Category();
        newCategory.setName(category.getName());
        newCategory.setDefault(category.getUserId() == 0);
        newCategory.setType(category.getType());
        newCategory.setUser(category.getUserId() == 0 ? null : userService.getUserById(category.getUserId()));
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
