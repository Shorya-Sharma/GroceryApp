package com.hdfc.Grocery.App.service;

import com.hdfc.Grocery.App.dao.ReviewRepository;
import com.hdfc.Grocery.App.entity.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    // Other service methods as needed
}
