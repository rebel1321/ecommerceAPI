package com.satya.ecommerce_satya.service;

import com.satya.ecommerce_satya.exception.ProductException;
import com.satya.ecommerce_satya.model.Cart;
import com.satya.ecommerce_satya.model.User;
import com.satya.ecommerce_satya.request.AddItemRequest;

public interface CartService {

    public Cart createCart(User user);

    public String addCartItem(Long userId, AddItemRequest req) throws ProductException;

    public Cart findUserCart(Long userId);
}
