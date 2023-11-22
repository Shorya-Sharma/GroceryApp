package com.hdfc.Grocery.App.dao;

import com.hdfc.Grocery.App.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {
    // Define custom query methods if needed
}
