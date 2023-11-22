package com.hdfc.Grocery.App.service;

import com.hdfc.Grocery.App.dao.CategoryRepository;
import com.hdfc.Grocery.App.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Optional<Category> getCategoryById(Long categoryId) {
        return categoryRepository.findById(categoryId);
    }

    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    public Category updateCategory(Long categoryId, Category updatedCategory) {
        Optional<Category> existingCategoryOptional = categoryRepository.findById(categoryId);

        if (existingCategoryOptional.isPresent()) {
            Category existingCategory = existingCategoryOptional.get();
            existingCategory.setCategoryName(updatedCategory.getCategoryName());
            // Update other fields as needed
            return categoryRepository.save(existingCategory);
        } else {
            // Handle category not found
            return null;
        }
    }

    public void deleteCategory(Long categoryId) {
        categoryRepository.deleteById(categoryId);
    }
}

