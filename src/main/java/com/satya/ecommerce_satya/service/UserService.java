package com.satya.ecommerce_satya.service;

import com.satya.ecommerce_satya.exception.UserException;
import com.satya.ecommerce_satya.model.User;


public interface UserService {

    public User findUserById(long userId) throws UserException;
    public User findUserprofileByJwt(String jwt) throws UserException;
}
