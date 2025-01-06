package com.satya.ecommerce_satya.controller;

import com.satya.ecommerce_satya.exception.ProductException;
import com.satya.ecommerce_satya.exception.UserException;
import com.satya.ecommerce_satya.model.Rating;
import com.satya.ecommerce_satya.model.User;
import com.satya.ecommerce_satya.request.RatingRequest;
import com.satya.ecommerce_satya.service.RatingService;
import com.satya.ecommerce_satya.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ratings")
public class RatingController{
    @Autowired
    private UserService userService;
    @Autowired
    private RatingService ratingService;

    @PostMapping("/create")
    public ResponseEntity<Rating>createRating(@RequestBody RatingRequest req,
                                              @RequestHeader("Authorization") String jwt) throws UserException, ProductException{
        User user=userService.findUserprofileByJwt(jwt);
        Rating ratings=ratingService.createRating(req,user);
        return  new ResponseEntity<>(ratings, HttpStatus.CREATED);
    }
    @GetMapping("/product/{productId}")
    public ResponseEntity<List<Rating>> getProductRating(@PathVariable Long productId,
                                                    @RequestHeader("Authorization") String jwt) throws UserException, ProductException{
        User user=userService.findUserprofileByJwt(jwt);
        List<Rating> ratings=ratingService.getProductsRating(productId);
        return  new ResponseEntity<>(ratings, HttpStatus.OK);
    }
}
