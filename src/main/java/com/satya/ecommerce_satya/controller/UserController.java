package com.satya.ecommerce_satya.controller;

import com.satya.ecommerce_satya.exception.UserException;
import com.satya.ecommerce_satya.model.User;
import com.satya.ecommerce_satya.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;



    @GetMapping("/profile")
    public ResponseEntity<User> getUserProfileHandler(@RequestHeader("Authorization") String jwt) throws UserException{
        User user=userService.findUserprofileByJwt(jwt);
        return  new ResponseEntity<User>(user, HttpStatus.ACCEPTED);
    }
}
