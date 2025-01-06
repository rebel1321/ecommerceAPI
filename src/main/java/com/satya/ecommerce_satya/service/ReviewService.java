package com.satya.ecommerce_satya.service;

import com.satya.ecommerce_satya.exception.ProductException;
import com.satya.ecommerce_satya.model.Review;
import com.satya.ecommerce_satya.model.User;
import com.satya.ecommerce_satya.request.ReviewRequest;

import java.util.List;

public interface ReviewService {

    public Review createReview(ReviewRequest req, User user)throws ProductException;

    public List<Review> getAllReview(Long productId);
}
