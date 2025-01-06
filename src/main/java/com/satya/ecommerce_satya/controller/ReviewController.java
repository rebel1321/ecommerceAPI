package com.satya.ecommerce_satya.controller;

import com.satya.ecommerce_satya.exception.ProductException;
import com.satya.ecommerce_satya.exception.UserException;
import com.satya.ecommerce_satya.model.Review;
import com.satya.ecommerce_satya.model.User;
import com.satya.ecommerce_satya.request.ReviewRequest;
import com.satya.ecommerce_satya.service.ReviewService;
import com.satya.ecommerce_satya.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<Review>createReview(@RequestBody ReviewRequest req,
                                              @RequestHeader("Authorization") String jwt)
            throws UserException, ProductException{
        User user=userService.findUserprofileByJwt(jwt);
        Review review=reviewService.createReview(req,user);
        return  new ResponseEntity<>(review, HttpStatus.CREATED);
    }
    @GetMapping("/product/{productId}")
    public ResponseEntity<List<Review>> getProductReview(@PathVariable Long productId) throws UserException, ProductException{

        List<Review> reviews=reviewService.getAllReview(productId);
        return  new ResponseEntity<>(reviews, HttpStatus.OK);
    }
}
