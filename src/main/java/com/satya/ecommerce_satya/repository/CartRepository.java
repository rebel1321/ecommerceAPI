package com.satya.ecommerce_satya.repository;

import com.satya.ecommerce_satya.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CartRepository extends JpaRepository<Cart,Long> {

    @Query("SELECT c From Cart c Where c.user.id=:userId")
    public Cart findByUserId(@Param("userId")Long userId);
}
