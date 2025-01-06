package com.satya.ecommerce_satya.service;

import com.satya.ecommerce_satya.exception.CartItemException;
import com.satya.ecommerce_satya.exception.UserException;
import com.satya.ecommerce_satya.model.Cart;
import com.satya.ecommerce_satya.model.CartItem;
import com.satya.ecommerce_satya.model.Product;

public interface CartItemService {
    public CartItem createCartItem(CartItem cartItem);
    public CartItem updateCartItem(Long userId,Long id,CartItem cartItem) throws CartItemException, UserException;

    public CartItem isCartItemExist(Cart cart, Product product,String size,Long userId);
    public void removeCartItem(Long userId,Long cartItemId) throws CartItemException,UserException;

    public CartItem findCartItemById(Long cartItemId)throws CartItemException;
}
