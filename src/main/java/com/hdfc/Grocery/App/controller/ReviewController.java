package com.hdfc.Grocery.App.controller;

import com.hdfc.Grocery.App.entity.Review;
import com.hdfc.Grocery.App.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping
    public List<Review> getAllReviews() {
        return reviewService.getAllReviews();
    }

    // Other controller methods for review endpoints
}
