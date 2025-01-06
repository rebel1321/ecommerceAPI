package com.satya.ecommerce_satya.service;

import com.satya.ecommerce_satya.config.JwtProvider;
import com.satya.ecommerce_satya.exception.UserException;
import com.satya.ecommerce_satya.model.User;
import com.satya.ecommerce_satya.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImplementation implements UserService{

    private UserRepository userRepository;
    private JwtProvider jwtProvider;


    public UserServiceImplementation(UserRepository userRepository, JwtProvider jwtProvider) {
        this.userRepository=userRepository;
        this.jwtProvider=jwtProvider;
    }
    @Override
    public User findUserById(long userId) throws UserException {
        Optional<User>user=userRepository.findById(userId);
        if(user.isPresent()){
            return user.get();
        }
        throw new UserException("user not found with id:"+userId);
    }

    @Override
    public User findUserprofileByJwt(String jwt) throws UserException {
        String email=jwtProvider.getEmailFromToken(jwt);

        User user=userRepository.findByEmail(email);
        if(user==null){
            throw new UserException("user not found with email"+email);
        }
        return user;
    }
}
