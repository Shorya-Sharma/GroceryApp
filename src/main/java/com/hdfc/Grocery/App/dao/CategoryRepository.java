package com.hdfc.Grocery.App.dao;

import com.hdfc.Grocery.App.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    // Additional query methods can be defined here if needed
}

