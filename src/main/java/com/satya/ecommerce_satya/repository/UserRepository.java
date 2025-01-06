package com.satya.ecommerce_satya.repository;

import com.satya.ecommerce_satya.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    public User findByEmail(String email);

}
